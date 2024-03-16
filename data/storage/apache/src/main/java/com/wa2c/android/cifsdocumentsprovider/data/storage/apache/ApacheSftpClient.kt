package com.wa2c.android.cifsdocumentsprovider.data.storage.apache

import android.content.Context
import android.net.Uri
import android.os.ProxyFileDescriptorCallback
import android.os.storage.StorageManager
import androidx.documentfile.provider.DocumentFile
import com.wa2c.android.cifsdocumentsprovider.common.values.AccessMode
import com.wa2c.android.cifsdocumentsprovider.common.values.CONNECTION_TIMEOUT
import com.wa2c.android.cifsdocumentsprovider.data.storage.interfaces.StorageConnection
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import org.apache.commons.vfs2.FileObject
import org.apache.commons.vfs2.FileSystemOptions
import org.apache.commons.vfs2.provider.sftp.BytesIdentityInfo
import org.apache.commons.vfs2.provider.sftp.SftpFileSystemConfigBuilder
import java.time.Duration

class ApacheSftpClient(
    openFileLimit: Int,
    private val onKeyRead: (String) -> ByteArray?,
    dispatcher: CoroutineDispatcher = Dispatchers.IO,
): ApacheVfsClient(openFileLimit, dispatcher) {

    override fun applyOptions(options: FileSystemOptions, storageConnection: StorageConnection) {
        val sftpConnection = storageConnection as StorageConnection.Sftp

        SftpFileSystemConfigBuilder.getInstance().also { builder ->
            builder.setConnectTimeout(options, Duration.ofMillis(CONNECTION_TIMEOUT.toLong()))
            builder.setSessionTimeout(options, Duration.ofMillis(CONNECTION_TIMEOUT.toLong()))
            builder.setPreferredAuthentications(options, "password,publickey")
            builder.setStrictHostKeyChecking(options, "no")
            builder.setFileNameEncoding(options, "UTF-8")
            // Key
            sftpConnection.keyData?.encodeToByteArray() ?: sftpConnection.keyFileUri?.let { uri ->
                try { onKeyRead(uri) } catch (e: Exception) { null }
            }?.let {
                val identity = BytesIdentityInfo(it, sftpConnection.password?.encodeToByteArray())
                builder.setIdentityProvider(options, identity)
            }
        }
    }

    override fun getProxyFileDescriptorCallback(
        fileObject: FileObject,
        accessMode: AccessMode,
        onFileRelease: suspend () -> Unit,
    ): ProxyFileDescriptorCallback {
        return ApacheProxyFileCallback(fileObject, accessMode, onFileRelease)
    }

}
