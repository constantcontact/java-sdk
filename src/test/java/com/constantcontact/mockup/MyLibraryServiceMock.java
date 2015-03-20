package com.constantcontact.mockup;

import com.constantcontact.components.Component;
import com.constantcontact.components.generic.response.ResultSet;
import com.constantcontact.components.library.file.ImageSource;
import com.constantcontact.components.library.file.MyLibraryFile;
import com.constantcontact.components.library.folder.MyLibraryFolder;
import com.constantcontact.components.library.folder.MyLibraryFolder.FolderSortOptions;
import com.constantcontact.components.library.info.MoveResults;
import com.constantcontact.components.library.info.MyLibrarySummary;
import com.constantcontact.components.library.info.UploadStatus;
import com.constantcontact.exceptions.component.ConstantContactComponentException;
import com.constantcontact.exceptions.service.ConstantContactServiceException;
import com.constantcontact.services.library.MyLibraryService;
import com.constantcontact.util.RawApiResponse;
import com.constantcontact.util.ConstantContactExceptionFactory;
import com.constantcontact.util.http.MultipartBody;

import java.util.List;

public class MyLibraryServiceMock extends MyLibraryService {

    /**
     * Retrieves the information for the MyLibrary product for this account
     * 
     * @param accessToken
     *            The Access Token for your user
     * @throws {@link com.constantcontact.exceptions.service.ConstantContactServiceException} When something went wrong
     *         in the Constant Contact flow or an error is returned from server.
     * @return The {@link com.constantcontact.components.library.info.MyLibrarySummary} Data
     */
    @Override
    public MyLibrarySummary getLibraryInfo(String accessToken) throws ConstantContactServiceException {

        MyLibrarySummary summary = null;

            try {

                summary = Component.fromJSON(MockedServerResponses.getLibraryInfoMyLibraryServiceData, MyLibrarySummary.class);
            }
            catch (ConstantContactComponentException e) {
                throw new ConstantContactServiceException(e);
            }

        return summary;

    }

    /**
     * Retrieves the list of folders
     * 
     * @param accessToken
     *            The Access Token for your user
     * @param sortBy
     *            The method to sort by. See {@link com.constantcontact.components.library.folder.MyLibraryFolder.FolderSortOptions}. Leave
     *            null to not use
     * @param limit
     *            The number of results to return. Leave null to use default.
     * @throws {@link com.constantcontact.exceptions.service.ConstantContactServiceException} When something went wrong
     *         in the Constant Contact flow or an error is returned from server.
     * @return The {@link com.constantcontact.components.generic.response.ResultSet} of {@link com.constantcontact.components.library.folder.MyLibraryFolder} Data
     */
    @Override
    public ResultSet<MyLibraryFolder> getLibraryFolders(String accessToken, FolderSortOptions sortBy, Integer limit)
            throws ConstantContactServiceException {
        ResultSet<MyLibraryFolder> folders = null;

            try {

                folders = Component.resultSetFromJSON(MockedServerResponses.getLibraryFoldersMyLibraryServiceData, MyLibraryFolder.class);
            }
            catch (ConstantContactComponentException e) {
                throw new ConstantContactServiceException(e);
            }

        return folders;
    }

    /**
     * Add Library Folder API.<br/>
     * 
     * @param accessToken
     *            The Access Token for your user
     * @param folder
     *            The {@link com.constantcontact.components.library.folder.MyLibraryFolder} to add.
     * @return The added Folder.
     * @throws com.constantcontact.exceptions.service.ConstantContactServiceException
     *             Thrown when :
     *             <ul>
     *             <li>something went wrong either on the client side;</li>
     *             <li>or an error message was received from the server side.</li>
     *             </ul>
     * <br/>
     *             To check if a detailed error message is present, call
     *             {@link com.constantcontact.exceptions.ConstantContactException#hasErrorInfo()} <br/>
     *             Detailed error message (if present) can be seen by calling
     *             {@link com.constantcontact.exceptions.ConstantContactException#getErrorInfo()}
     */
    @Override
    public MyLibraryFolder addLibraryFolder(String accessToken, MyLibraryFolder folder) throws ConstantContactServiceException {
        MyLibraryFolder newFolder = null;
        try {
                newFolder = Component.fromJSON(MockedServerResponses.addLibraryFolderMyLibraryServiceData, MyLibraryFolder.class);
        }
        catch (ConstantContactComponentException e) {
            throw new ConstantContactServiceException(e);
        }

        return newFolder;
    }

    /**
     * Get Library Folder API.<br/>
     * 
     * @param accessToken
     *            The Access Token for your user
     * @param folderId
     *            The ID for the Folder to return.
     * @return The added {@link com.constantcontact.components.library.folder.MyLibraryFolder}.
     * @throws com.constantcontact.exceptions.service.ConstantContactServiceException
     *             Thrown when :
     *             <ul>
     *             <li>something went wrong either on the client side;</li>
     *             <li>or an error message was received from the server side.</li>
     *             </ul>
     * <br/>
     *             To check if a detailed error message is present, call
     *             {@link com.constantcontact.exceptions.ConstantContactException#hasErrorInfo()} <br/>
     *             Detailed error message (if present) can be seen by calling
     *             {@link com.constantcontact.exceptions.ConstantContactException#getErrorInfo()}
     */
    @Override
    public MyLibraryFolder getLibraryFolder(String accessToken, String folderId) throws ConstantContactServiceException {
        MyLibraryFolder folder = null;

            try {

                folder = Component.fromJSON(MockedServerResponses.getLibraryFolderMyLibraryServiceData, MyLibraryFolder.class);
            }
            catch (ConstantContactComponentException e) {
                throw new ConstantContactServiceException(e);
            }

        return folder;
    }

    /**
     * Update Library Folder API.<br/>
     * 
     * @param accessToken
     *            The Access Token for your user
     * @param folder
     *            The Folder to update.
     * @param includePayload
     *            If the result should be the updated Folder or NULL (defaults
     *            to true if left null)
     * @return The added {@link com.constantcontact.components.library.folder.MyLibraryFolder}, or Null if includePayload was false.
     * @throws com.constantcontact.exceptions.service.ConstantContactServiceException
     *             Thrown when :
     *             <ul>
     *             <li>something went wrong either on the client side;</li>
     *             <li>or an error message was received from the server side.</li>
     *             </ul>
     * <br/>
     *             To check if a detailed error message is present, call
     *             {@link com.constantcontact.exceptions.ConstantContactException#hasErrorInfo()} <br/>
     *             Detailed error message (if present) can be seen by calling
     *             {@link com.constantcontact.exceptions.ConstantContactException#getErrorInfo()}
     */
    @Override
    public MyLibraryFolder updateLibraryFolder(String accessToken, MyLibraryFolder folder, Boolean includePayload)
            throws ConstantContactServiceException {

        MyLibraryFolder updateFolder = null;

            try {
                updateFolder = Component.fromJSON(MockedServerResponses.updateLibraryFolderMyLibrariServiceData, MyLibraryFolder.class);
            }
            catch (ConstantContactComponentException e) {
                throw new ConstantContactServiceException(e);
            }

        if (includePayload == null || includePayload.booleanValue() == true) {
            return updateFolder;
        }
        else {
            return null;
        }
    }

    /**
     * Delete Library Folder API.<br/>
     * 
     * @param accessToken
     *            The Access Token for your user
     * @param folderId
     *            The ID for the Folder to delete.
     * @return Void. Exceptions are raised on failures.
     * @throws com.constantcontact.exceptions.service.ConstantContactServiceException
     *             Thrown when :
     *             <ul>
     *             <li>something went wrong either on the client side;</li>
     *             <li>or an error message was received from the server side.</li>
     *             </ul>
     * <br/>
     *             To check if a detailed error message is present, call
     *             {@link com.constantcontact.exceptions.ConstantContactException#hasErrorInfo()} <br/>
     *             Detailed error message (if present) can be seen by calling
     *             {@link com.constantcontact.exceptions.ConstantContactException#getErrorInfo()}
     */
    @Override
    public void deleteLibraryFolder(String accessToken, String folderId) throws ConstantContactServiceException {

        return;
    }
    
    /**
     * Retrieve Library Trash API.<br/>
     * 
     * @param accessToken The Access Token for your user
     * @param type - The type of files to return. Null for default.
     * @param sortBy - The way to sort results. Null for default
     * @param limit - The number of results to return per page.
     * @return A {@link com.constantcontact.components.generic.response.ResultSet} of {@link com.constantcontact.components.library.file.MyLibraryFile} in case of success; an exception is thrown otherwise.
     * @throws com.constantcontact.exceptions.service.ConstantContactServiceException Thrown when :
     *             <ul>
     *             <li>something went wrong either on the client side;</li>
     *             <li>or an error message was received from the server side.</li>
     *             </ul>
     * <br/>
     *             To check if a detailed error message is present, call {@link com.constantcontact.exceptions.ConstantContactException#hasErrorInfo()} <br/>
     *             Detailed error message (if present) can be seen by calling {@link com.constantcontact.exceptions.ConstantContactException#getErrorInfo()}
     */
    @Override
    public ResultSet<MyLibraryFile> getLibraryTrash(String accessToken, MyLibraryFile.Type type, MyLibraryFile.SortBy sortBy, Integer limit) throws ConstantContactServiceException{
        ResultSet<MyLibraryFile> files = null;

            try {

                files = Component.resultSetFromJSON(MockedServerResponses.getLibraryTrashMyLibraryServiceData, MyLibraryFile.class);
            }
            catch (ConstantContactComponentException e) {
                throw new ConstantContactServiceException(e);
            }

          return files;        
    }

    /**
     * Delete Library Trash API.<br/>
     * 
     * @param accessToken The Access Token for your user
     * @return Void
     * @throws com.constantcontact.exceptions.service.ConstantContactServiceException Thrown when :
     *             <ul>
     *             <li>something went wrong either on the client side;</li>
     *             <li>or an error message was received from the server side.</li>
     *             </ul>
     * <br/>
     *             To check if a detailed error message is present, call {@link com.constantcontact.exceptions.ConstantContactException#hasErrorInfo()} <br/>
     *             Detailed error message (if present) can be seen by calling {@link com.constantcontact.exceptions.ConstantContactException#getErrorInfo()}
     */
    @Override
    public void deleteLibraryTrash(String accessToken) throws ConstantContactServiceException{

        return;
    }
    
    /**
     * Retrieve Library File API.<br/>
     * 
     * @param accessToken The Access Token for your user
     * @param type - The type of files to return. Null for default.
     * @param source - The source of the files. Null for default.
     * @param sortBy - The way to sort results. Null for default
     * @param limit - The number of results to return per page.
     * @return A {@link com.constantcontact.components.generic.response.ResultSet} of {@link com.constantcontact.components.library.file.MyLibraryFile} in case of success; an exception is thrown otherwise.
     * @throws com.constantcontact.exceptions.service.ConstantContactServiceException Thrown when :
     *             <ul>
     *             <li>something went wrong either on the client side;</li>
     *             <li>or an error message was received from the server side.</li>
     *             </ul>
     * <br/>
     *             To check if a detailed error message is present, call {@link com.constantcontact.exceptions.ConstantContactException#hasErrorInfo()} <br/>
     *             Detailed error message (if present) can be seen by calling {@link com.constantcontact.exceptions.ConstantContactException#getErrorInfo()}
     */
    @Override
    public ResultSet<MyLibraryFile> getLibraryFiles(String accessToken, MyLibraryFile.Type type, ImageSource source, MyLibraryFile.SortBy sortBy, Integer limit) throws ConstantContactServiceException{
        ResultSet<MyLibraryFile> files = null;

          try {

              files = Component.resultSetFromJSON(MockedServerResponses.getLibraryFilesMyLibraryServiceData, MyLibraryFile.class);
          }
          catch (ConstantContactComponentException e) {
              throw new ConstantContactServiceException(e);
          }

        return files;           
    }
    
    /**
     * Retrieve Library Files By Folder API.<br/>
     * 
     * @param accessToken The Access Token for your user
     * @param folderId - The library Folder Id
     * @param limit - The number of results to return per page.
     * @return A {@link com.constantcontact.components.generic.response.ResultSet} of {@link com.constantcontact.components.library.file.MyLibraryFile} in case of success; an exception is thrown otherwise.
     * @throws com.constantcontact.exceptions.service.ConstantContactServiceException Thrown when :
     *             <ul>
     *             <li>something went wrong either on the client side;</li>
     *             <li>or an error message was received from the server side.</li>
     *             </ul>
     * <br/>
     *             To check if a detailed error message is present, call {@link com.constantcontact.exceptions.ConstantContactException#hasErrorInfo()} <br/>
     *             Detailed error message (if present) can be seen by calling {@link com.constantcontact.exceptions.ConstantContactException#getErrorInfo()}
     */
    @Override
    public ResultSet<MyLibraryFile> getLibraryFilesByFolder(String accessToken, String folderId, Integer limit) throws ConstantContactServiceException{
        ResultSet<MyLibraryFile> files = null;

          try {

              files = Component.resultSetFromJSON(MockedServerResponses.getLibraryFilesByFolderMyLibraryServiceData, MyLibraryFile.class);
          }
          catch (ConstantContactComponentException e) {
              throw new ConstantContactServiceException(e);
          }

        return files;           
    }
    
    /**
     * Get Library File API.<br/>
     * 
     * @param accessToken The Access Token for your user
     * @param fileId The ID for the File to return.
     * @return The added {@link com.constantcontact.components.library.file.MyLibraryFile}.
     * @throws com.constantcontact.exceptions.service.ConstantContactServiceException Thrown when :
     *             <ul>
     *             <li>something went wrong either on the client side;</li>
     *             <li>or an error message was received from the server side.</li>
     *             </ul>
     * <br/>
     *             To check if a detailed error message is present, call {@link com.constantcontact.exceptions.ConstantContactException#hasErrorInfo()} <br/>
     *             Detailed error message (if present) can be seen by calling {@link com.constantcontact.exceptions.ConstantContactException#getErrorInfo()}
     */
    @Override
    public MyLibraryFile getLibraryFile(String accessToken, String fileId) throws ConstantContactServiceException{
        MyLibraryFile file = null;
            try {

                file = Component.fromJSON(MockedServerResponses.getLibraryFileMyLibraryServiceData, MyLibraryFile.class);
            }
            catch (ConstantContactComponentException e) {
                throw new ConstantContactServiceException(e);
            }

        return file;
    }
    
    /**
     * Update Library File API.<br/>
     * 
     * @param accessToken The Access Token for your user
     * @param file The Folder to update.
     * @param includePayload If the result should be the updated File or NULL (defaults to true if left null)
     * @return The added {@link com.constantcontact.components.library.file.MyLibraryFile}, or Null if includePayload was false.
     * @throws com.constantcontact.exceptions.service.ConstantContactServiceException Thrown when :
     *             <ul>
     *             <li>something went wrong either on the client side;</li>
     *             <li>or an error message was received from the server side.</li>
     *             </ul>
     * <br/>
     *             To check if a detailed error message is present, call {@link com.constantcontact.exceptions.ConstantContactException#hasErrorInfo()} <br/>
     *             Detailed error message (if present) can be seen by calling {@link com.constantcontact.exceptions.ConstantContactException#getErrorInfo()}
     */
    @Override
    public MyLibraryFile updateLibraryFile(String accessToken, MyLibraryFile file, Boolean includePayload) throws ConstantContactServiceException {
        MyLibraryFile updateFile = null;
            try {

                updateFile = Component.fromJSON(MockedServerResponses.updateLibraryFileMyLibraryServiceData, MyLibraryFile.class);
            }
            catch (ConstantContactComponentException e) {
                throw new ConstantContactServiceException(e);
            }

        if (includePayload == null || includePayload.booleanValue() == true) {
            return updateFile;
        }
        else {
            return null;
        }
    }
    
    /**
     * Delete Library File API.<br/>
     * 
     * @param accessToken The Access Token for your user
     * @param fileId The ID for the Folder to delete.
     * @return Void. Exceptions are raised on failures.
     * @throws com.constantcontact.exceptions.service.ConstantContactServiceException Thrown when :
     *             <ul>
     *             <li>something went wrong either on the client side;</li>
     *             <li>or an error message was received from the server side.</li>
     *             </ul>
     * <br/>
     *             To check if a detailed error message is present, call {@link com.constantcontact.exceptions.ConstantContactException#hasErrorInfo()} <br/>
     *             Detailed error message (if present) can be seen by calling {@link com.constantcontact.exceptions.ConstantContactException#getErrorInfo()}
     */
    @Override
    public void deleteLibraryFile(String accessToken, String fileId) throws ConstantContactServiceException {

        return;   
    }
    
    /**
     * Retrieves the Status of files uploaded to the Library <br />
     * 
     * @param accessToken The Access Token for your user
     * @param fileId A varargs list of fileIds to return results for.
     * @throws {@link com.constantcontact.exceptions.service.ConstantContactServiceException} When something went wrong
     *         in the Constant Contact flow or an error is returned from server.
     * @return The {@link java.util.List} of {@link com.constantcontact.components.library.info.UploadStatus} Data
     */
    @Override
    public List<UploadStatus> getLibraryFilesUploadStatus(String accessToken, String ... fileId) throws ConstantContactServiceException {
        
        List<UploadStatus> uploadStatuses = null;
            try {

                uploadStatuses = Component.listFromJSON(MockedServerResponses.getLibraryFilesUploadStatusMyLibraryServiceData, UploadStatus.class);
            }
            catch (ConstantContactComponentException e) {
                throw new ConstantContactServiceException(e);
            }

        return uploadStatuses;
    }
    
    /**
     * Moves files from one folder to another <br />
     * 
     * @param accessToken The Access Token for your user
     * @param folderId The folder to put the files in
     * @param body The JSON body [an array of fileIds]
     * @throws {@link com.constantcontact.exceptions.service.ConstantContactServiceException} When something went wrong
     *         in the Constant Contact flow or an error is returned from server.
     * @throws IllegalArgumentException Thrown when data validation failed due to incorrect / missing parameter values. <br/>
     *         The exception also contains a description of the cause.<br/>
     *         Error message is taken from one of the members of {@link com.constantcontact.util.Config.Errors}
     * @return The {@link java.util.List} of {@link com.constantcontact.components.library.info.MoveResults} Data
     */
    @Override
    public List<MoveResults> moveLibraryFiles(String accessToken, String folderId, String body) throws ConstantContactServiceException {

        List<MoveResults> movedResults = null;
            try {

                movedResults = Component.listFromJSON(MockedServerResponses.moveLibraryFilesMyLibraryServiceData, MoveResults.class);
            }
            catch (ConstantContactComponentException e) {
                throw new ConstantContactServiceException(e);
            }

        return movedResults;
    }
    
    /**
     * Adds a file to the library <br />
     * 
     * @param accessToken The Access Token for your user
     * @param  request The {@link com.constantcontact.util.http.MultipartBody} to upload
     * @return The fileId associated with the uploaded file
     * @throws {@link com.constantcontact.exceptions.service.ConstantContactServiceException} When something went wrong
     *         in the Constant Contact flow or an error is returned from server.
     */
    @Override
    public String addLibraryFile(String accessToken, MultipartBody request) throws ConstantContactServiceException {
        return MockedServerResponses.addLibraryFileMyLibraryServiceData;
    }
    
    private static void checkForResponseError(RawApiResponse response, String url) throws ConstantContactServiceException {
        if (response.isError()) {
            throw ConstantContactExceptionFactory.createServiceException(response, url);
        }
    }
}
