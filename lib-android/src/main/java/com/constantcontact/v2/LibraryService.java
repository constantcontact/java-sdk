package com.constantcontact.v2;

import com.constantcontact.v2.library.*;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.*;

/**
 * Retrofit interface for Library Information, File, and Folder calls against the Constant Contact API
 *
 * @author woogienoogie
 */
public interface LibraryService {
    /**
     * Get the Account's {@link LibraryInfo}
     *
     * @return an Observable that emits LibraryInfo
     */
    @GET("com.constantcontact.v2/library/info")
    Call<LibraryInfo> getLibraryInfo();

    /**
     * Get a {@link Paged} collection of {@link Folder}
     *
     * @param limit     Size of page to return (1-1000)
     * @param sortOrder {@link FolderSortOrder}
     * @return          an Observable that emits Paged Folders
     */
    @GET("com.constantcontact.v2/library/folders")
    Call<Paged<Folder>> getFolders(@Query("limit") int limit, @Query("sort_by") FolderSortOrder sortOrder);

    /**
     * Get a {@link Paged} collection of {@link Folder}
     * @param nextLink Value of the link found in the meta of the original call
     * @return         an Observable that emits Paged Folders
     */
    @GET("com.constantcontact.v2/library/folders?next={next}")
    Call<Paged<Folder>> getFolders(@Path("next") String nextLink);

    /**
     * Create a new {@link Folder}
     *
     * @param folder Folder with only the name and parentId values
     * @return       an Observable that emits a Folder
     */
    @POST("com.constantcontact.v2/library/folders")
    Call<Folder> createFolder(@Body Folder folder);

    /**
     * Get a specific {@link Folder}
     *
     * @param folderId The Folder ID
     * @return         an Observable that emits a Folder
     */
    @GET("com.constantcontact.v2/library/folders/{folderId}")
    Call<Folder> getFolder(@Path("folderId") String folderId);

    /**
     * Update a {@link Folder}
     *
     * @param folderId The Folder ID
     * @param folder   Folder
     * @return         an Observable that emits an updated Folder
     */
    @PUT("com.constantcontact.v2/library/folders/{folderId}?include_payload=TRUE")
    Call<Folder> updateFolder(@Path("folderId") String folderId, @Body Folder folder);

    /**
     * Delete a {@link Folder}
     *
     * @param folderId The Folder ID
     * @return         an Observable that emits a {@link retrofit2.Response}
     */
    @DELETE("com.constantcontact.v2/library/folders/{folderId}")
    Call<Response> deleteFolder(@Path("folderId") String folderId);

    /**
     * Get a {@link Paged} collection of {@link File}
     *
     * @param limit     Size of page to return (1-1000)
     * @param sortOrder {@link FileSortOrder}
     * @param source    {@link FileSource}
     * @param type      {@link FileTypeQuery}
     * @return          an Observable that emits Paged Files
     */
    @GET("com.constantcontact.v2/library/files")
    Call<Paged<File>> getFiles(@Query("limit") int limit, @Query("sort_by") FileSortOrder sortOrder, @Query("source") FileSource source,
                               @Query("type") FileTypeQuery type);

    /**
     * Get a {@link Paged} collection of {@link File}
     *
     * @param nextLink Value of the link found in the meta of the original call
     * @return         an Observable that emits Paged Files
     */
    @GET("com.constantcontact.v2/library/files?next={next}")
    Call<Paged<File>> getFiles(@Path("next") String nextLink);

    /**
     * Get a {@link Paged} collection of {@link File} from a specific {@link Folder}.
     * <p>
     * To get a list of files in the trash folder, pass "trash" as the folderId.
     *
     * @param folderId  The Folder ID
     * @param limit     Size of page to return (1-1000)
     * @param sortOrder {@link FileSortOrder}
     * @param source    {@link FileSource}
     * @param type      {@link FileTypeQuery}
     * @return          an Observable that emits Paged Files
     */
    @GET("com.constantcontact.v2/library/folders/{folderId}/files")
    Call<Paged<File>> getFilesByFolder(@Path("folderId") String folderId, @Query("limit") int limit,
                                       @Query("sort_by") FileSortOrder sortOrder, @Query("source") FileSource source,
                                       @Query("type") FileTypeQuery type);

    /**
     * Get a {@link Paged} collection of {@link File} from a specific {@link Folder}.
     *
     * @param folderId The Folder ID
     * @param nextLink Value of the link found in the meta of the original call
     * @return         an Observable that emits Paged Files
     */
    @GET("com.constantcontact.v2/library/folders/{folderId}/files?next={next}")
    Call<Paged<File>> getFilesByFolder(@Path("folderId") String folderId, @Path("next") String nextLink);

    /**
     * Get a specific {@link File}
     *
     * @param fileId The File ID
     * @return       an Observable that emits a File
     */
    @GET("com.constantcontact.v2/library/files/{fileId}")
    Call<File> getFile(@Path("fileId") String fileId);

    /**
     * Update a {@link File}
     *
     * @param fileId The File ID
     * @param file   File
     * @return       an Observable that emits an updated File
     */
    @PUT("com.constantcontact.v2/library/files/{fileId}?include_payload=TRUE")
    Call<File> updateFile(@Path("fileId") String fileId, @Body File file);

    /**
     * Move multiple {@link File} to a different {@link Folder}
     *
     * @param folderId The Folder ID
     * @param fileIds  Array of File ID's that will be moved to the new folder
     * @return         an Observable that emits an Array of updated Files
     */
    @PUT("com.constantcontact.v2/library/folders/{folderId}/files")
    Call<File> moveFiles(@Path("folderId") String folderId, @Body String[] fileIds);

    /**
     * Delete a {@link File}
     *
     * @param fileId The File ID
     * @return       an Observable that emits a {@link retrofit2.Response}
     */
    @DELETE("com.constantcontact.v2/library/files/{fileId}")
    Call<Response> deleteFile(@Path("fileId") String fileId);

    /**
     * Delete all {@link File} in the Trash {@link Folder}
     *
     * @return an Observable that emits a {@link retrofit2.Response}
     */
    @DELETE("com.constantcontact.v2/library/folders/trash/files")
    Call<Response> deleteFilesInTrash();

    /**
     * Get the {@link FileUploadStatus} of one or more {@link File}
     *
     * @param fileIds Send one File ID, or multiples merged into one string separated by commas (no spaces)
     * @return        an Observable that emits an array of FileUploadStatuses
     */
    @GET("com.constantcontact.v2/library/files/uploadstatus/{fileId}")
    Call<FileUploadStatus[]> getFileUploadStatus(@Path("fileId") String fileIds);

    /**
     * Upload a new {@link File} to the Library
     *
     * @param file        File
     * @param description A description of the file
     * @param fileName    The name of the file
     * @param fileType    {@link FileType}
     * @param folderId    The ID of the {@link Folder} you wish to upload to
     * @param source      {@link FileSource}
     * @return            an Observable that emits a {@link retrofit2.Response} - the File's new ID
     *                    can be obtained from the headers of the Response
     */
    @Multipart
    @Headers("Content-Type: multipart/form-data")
    @POST("com.constantcontact.v2/library/files")
    Call<Response> uploadFile(@Part("data") RequestBody file, @Part("description") String description, @Part("file_name") String fileName,
                              @Part("file_type") String fileType, @Part("folder_id") String folderId, @Part("source") String source);
}
