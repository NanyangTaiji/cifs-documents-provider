package com.wa2c.android.cifsdocumentsprovider.data.storage.interfaces

import com.wa2c.android.cifsdocumentsprovider.common.utils.AppUtils.appendChild
import com.wa2c.android.cifsdocumentsprovider.common.values.Constants.URI_SEPARATOR
import com.wa2c.android.cifsdocumentsprovider.common.values.Constants.URI_START


/**
 * Storage Request
 */
data class StorageRequest(
    val connection: StorageConnection,
    val path: String? = null,
) {

    /** URI */
    val uri: String
        get() = appendChild(connection.uri,path ?: "", false)

    /** Share name */
    val shareName: String
        get() = uri
            .substringAfter(URI_START, "")
            .substringAfter(URI_SEPARATOR, "")
            .substringBefore(URI_SEPARATOR)

    /** Share path */
    val sharePath: String
        get() = uri
            .substringAfter(URI_START, "")
            .substringAfter(URI_SEPARATOR, "")
            .substringAfter(URI_SEPARATOR)

    /** True if this is root */
    val isRoot: Boolean
        get() = shareName.isEmpty()

    /** True if this is share root */
    val isShareRoot: Boolean
        get() = shareName.isNotEmpty() && sharePath.isEmpty()


    fun replacePathByUri(replaceUriText: String): StorageRequest {
        return copy(path = connection.getRelativePath(replaceUriText))
    }

}
