package com.constantcontact.services.library;

import java.io.UnsupportedEncodingException;
import java.util.List;

import com.constantcontact.components.Component;
import com.constantcontact.components.generic.response.ResultSet;
import com.constantcontact.components.library.file.MyLibraryFile;
import com.constantcontact.components.library.folder.MyLibraryFolder;
import com.constantcontact.components.library.folder.MyLibraryFolder.FolderSortOptions;
import com.constantcontact.components.library.info.MoveResults;
import com.constantcontact.components.library.info.MyLibrarySummary;
import com.constantcontact.components.library.info.UploadStatus;
import com.constantcontact.exceptions.ConstantContactException;
import com.constantcontact.exceptions.component.ConstantContactComponentException;
import com.constantcontact.exceptions.service.ConstantContactServiceException;
import com.constantcontact.services.base.BaseService;
import com.constantcontact.util.CUrlRequestError;
import com.constantcontact.util.CUrlResponse;
import com.constantcontact.util.Config;
import com.constantcontact.util.Config.Errors;

public class MyLibraryService extends BaseService implements IMyLibraryService {

    /**
     * Retrieves the information for the MyLibrary product for this account
     * 
     * @param accessToken
     *            The Access Token for your user
     * @throws {@link ConstantContactServiceException} When something went wrong
     *         in the Constant Contact flow or an error is returned from server.
     * @return The {@link MyLibrarySummary} Data
     */
    public MyLibrarySummary getLibraryInfo(String accessToken) throws ConstantContactServiceException {

        MyLibrarySummary summary = null;

        String url = String.format("%1$s%2$s", Config.Endpoints.BASE_URL, Config.Endpoints.LIBRARY_INFO);
        CUrlResponse response = getRestClient().get(url, accessToken);

        if (response.hasData()) {
            try {
                summary = Component.fromJSON(response.getBody(), MyLibrarySummary.class);
            }
            catch (ConstantContactComponentException e) {
                throw new ConstantContactServiceException(e);
            }
        }
        checkForResponseError(response, url);

        return summary;

    }

    /**
     * Retrieves the list of folders
     * 
     * @param accessToken
     *            The Access Token for your user
     * @param sortBy
     *            The method to sort by. See {@link FolderSortOptions}. Leave
     *            null to not use
     * @param limit
     *            The number of results to return. Leave null to use default.
     * @throws {@link ConstantContactServiceException} When something went wrong
     *         in the Constant Contact flow or an error is returned from server.
     * @return The {@link ResultSet} of {@link MyLibraryFolder} Data
     */
    public ResultSet<MyLibraryFolder> getLibraryFolders(String accessToken, MyLibraryFolder.FolderSortOptions sortBy, Integer limit)
            throws ConstantContactServiceException {
        ResultSet<MyLibraryFolder> folders = null;

        // Construct access URL
        String url = paginateUrl(
                String.format("%1$s%2$s", Config.Endpoints.BASE_URL, Config.Endpoints.LIBRARY_FOLDERS), limit);

        if (sortBy != null) {
            try {
                url = appendParam(url, "sort_by", sortBy.toString());
            }
            catch (UnsupportedEncodingException e) {
                throw new ConstantContactServiceException(e);
            }
        }

        // Get REST response
        CUrlResponse response = getRestClient().get(url, accessToken);
        if (response.hasData()) {
            try {
                folders = Component.resultSetFromJSON(response.getBody(), MyLibraryFolder.class);
            }
            catch (ConstantContactComponentException e) {
                throw new ConstantContactServiceException(e);
            }
        }
        checkForResponseError(response, url);

        return folders;
    }

    /**
     * Add Library Folder API.<br/>
     * 
     * @param accessToken
     *            The Access Token for your user
     * @param folder
     *            The {@link MyLibraryFolder} to add.
     * @return The added Folder.
     * @throws ConstantContactServiceException
     *             Thrown when :
     *             <ul>
     *             <li>something went wrong either on the client side;</li>
     *             <li>or an error message was received from the server side.</li>
     *             </ul>
     * <br/>
     *             To check if a detailed error message is present, call
     *             {@link ConstantContactException#hasErrorInfo()} <br/>
     *             Detailed error message (if present) can be seen by calling
     *             {@link ConstantContactException#getErrorInfo()}
     */
    public MyLibraryFolder addLibraryFolder(String accessToken, MyLibraryFolder folder) throws ConstantContactServiceException {
        MyLibraryFolder newFolder = null;
        try {
            String url = String.format("%1$s%2$s", Config.Endpoints.BASE_URL, Config.Endpoints.LIBRARY_FOLDERS);
            String json = folder.toJSON();

            CUrlResponse response = getRestClient().post(url, accessToken, json);
            if (response.hasData()) {
                newFolder = Component.fromJSON(response.getBody(), MyLibraryFolder.class);

            }
            checkForResponseError(response, url);

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
     * @return The added {@link MyLibraryFolder}.
     * @throws ConstantContactServiceException
     *             Thrown when :
     *             <ul>
     *             <li>something went wrong either on the client side;</li>
     *             <li>or an error message was received from the server side.</li>
     *             </ul>
     * <br/>
     *             To check if a detailed error message is present, call
     *             {@link ConstantContactException#hasErrorInfo()} <br/>
     *             Detailed error message (if present) can be seen by calling
     *             {@link ConstantContactException#getErrorInfo()}
     */
    public MyLibraryFolder getLibraryFolder(String accessToken, String folderId) throws ConstantContactServiceException {
        MyLibraryFolder folder = null;

        String url = String.format("%1$s%2$s", Config.Endpoints.BASE_URL,
                String.format(Config.Endpoints.LIBRARY_FOLDER, folderId));

        // Get REST response
        CUrlResponse response = getRestClient().get(url, accessToken);
        if (response.hasData()) {
            try {
                folder = Component.fromJSON(response.getBody(), MyLibraryFolder.class);
            }
            catch (ConstantContactComponentException e) {
                throw new ConstantContactServiceException(e);
            }
        }
        checkForResponseError(response, url);

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
     * @return The added {@link MyLibraryFolder}, or Null if includePayload was false.
     * @throws ConstantContactServiceException
     *             Thrown when :
     *             <ul>
     *             <li>something went wrong either on the client side;</li>
     *             <li>or an error message was received from the server side.</li>
     *             </ul>
     * <br/>
     *             To check if a detailed error message is present, call
     *             {@link ConstantContactException#hasErrorInfo()} <br/>
     *             Detailed error message (if present) can be seen by calling
     *             {@link ConstantContactException#getErrorInfo()}
     */
    public MyLibraryFolder updateLibraryFolder(String accessToken, MyLibraryFolder folder, Boolean includePayload)
            throws ConstantContactServiceException {

        MyLibraryFolder updateFolder = null;

        String url = String.format("%1$s%2$s", Config.Endpoints.BASE_URL,
                String.format(Config.Endpoints.LIBRARY_FOLDER, folder.getId()));
        String json;
        try {
            json = folder.toJSON();
        }
        catch (ConstantContactComponentException e) {
            throw new ConstantContactServiceException(e);
        }

        CUrlResponse response = getRestClient().put(url, accessToken, json);
        if (response.hasData()) {
            try {
                updateFolder = Component.fromJSON(response.getBody(), MyLibraryFolder.class);
            }
            catch (ConstantContactComponentException e) {
                throw new ConstantContactServiceException(e);
            }
        }
        checkForResponseError(response, url);

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
     * @throws ConstantContactServiceException
     *             Thrown when :
     *             <ul>
     *             <li>something went wrong either on the client side;</li>
     *             <li>or an error message was received from the server side.</li>
     *             </ul>
     * <br/>
     *             To check if a detailed error message is present, call
     *             {@link ConstantContactException#hasErrorInfo()} <br/>
     *             Detailed error message (if present) can be seen by calling
     *             {@link ConstantContactException#getErrorInfo()}
     */
    public void deleteLibraryFolder(String accessToken, String folderId) throws ConstantContactServiceException {
        String url = String.format("%1$s%2$s", Config.Endpoints.BASE_URL,
                String.format(Config.Endpoints.LIBRARY_FOLDER, folderId));

        // Get REST response
        CUrlResponse response = getRestClient().delete(url, accessToken);
        checkForResponseError(response, url);

        return;
    }
    
    /**
     * Retrieve Library Trash API.<br/>
     * 
     * @param accessToken The Access Token for your user
     * @param type - The type of files to return. Null for default.
     * @param sortBy - The way to sort results. Null for default
     * @param limit - The number of results to return per page.
     * @return A {@link ResultSet} of {@link MyLibraryFile} in case of success; an exception is thrown otherwise.
     * @throws ConstantContactServiceException Thrown when :
     *             <ul>
     *             <li>something went wrong either on the client side;</li>
     *             <li>or an error message was received from the server side.</li>
     *             </ul>
     * <br/>
     *             To check if a detailed error message is present, call {@link ConstantContactException#hasErrorInfo()} <br/>
     *             Detailed error message (if present) can be seen by calling {@link ConstantContactException#getErrorInfo()}
     */
    public ResultSet<MyLibraryFile> getLibraryTrash(String accessToken, MyLibraryFile.Type type, MyLibraryFile.SortBy sortBy, Integer limit) throws ConstantContactServiceException{
        ResultSet<MyLibraryFile> files = null;
        
          // Construct access URL
          String url = paginateUrl(String.format("%1$s%2$s", Config.Endpoints.BASE_URL, Config.Endpoints.LIBRARY_FOLDER_TRASH), limit);

          try {
              if (type != null) {
                 url = appendParam(url, "type", type.toString());
              }
              if (sortBy != null){
                  url = appendParam(url, "sort_by", sortBy.toString());
              }
          }
          catch (UnsupportedEncodingException e) {
              throw new ConstantContactServiceException(e);
          }
    
          // Get REST response
          CUrlResponse response = getRestClient().get(url, accessToken);
          if (response.hasData()) {
            try {
                files = Component.resultSetFromJSON(response.getBody(), MyLibraryFile.class);
            }
            catch (ConstantContactComponentException e) {
                throw new ConstantContactServiceException(e);
            }
          }
          checkForResponseError(response, url);

          return files;        
    }

    /**
     * Delete Library Trash API.<br/>
     * 
     * @param accessToken The Access Token for your user
     * @return Void
     * @throws ConstantContactServiceException Thrown when :
     *             <ul>
     *             <li>something went wrong either on the client side;</li>
     *             <li>or an error message was received from the server side.</li>
     *             </ul>
     * <br/>
     *             To check if a detailed error message is present, call {@link ConstantContactException#hasErrorInfo()} <br/>
     *             Detailed error message (if present) can be seen by calling {@link ConstantContactException#getErrorInfo()}
     */
    public void deleteLibraryTrash(String accessToken) throws ConstantContactServiceException{
        String url = String.format("%1$s%2$s", Config.Endpoints.BASE_URL, Config.Endpoints.LIBRARY_FOLDER_TRASH);

        // Get REST response
        CUrlResponse response = getRestClient().delete(url, accessToken);
        checkForResponseError(response, url);

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
     * @return A {@link ResultSet} of {@link MyLibraryFile} in case of success; an exception is thrown otherwise.
     * @throws ConstantContactServiceException Thrown when :
     *             <ul>
     *             <li>something went wrong either on the client side;</li>
     *             <li>or an error message was received from the server side.</li>
     *             </ul>
     * <br/>
     *             To check if a detailed error message is present, call {@link ConstantContactException#hasErrorInfo()} <br/>
     *             Detailed error message (if present) can be seen by calling {@link ConstantContactException#getErrorInfo()}
     */
    public ResultSet<MyLibraryFile> getLibraryFiles(String accessToken, MyLibraryFile.Type type, MyLibraryFile.Source source, MyLibraryFile.SortBy sortBy, Integer limit) throws ConstantContactServiceException{
        ResultSet<MyLibraryFile> files = null;
        
        // Construct access URL
        String url = paginateUrl(String.format("%1$s%2$s", Config.Endpoints.BASE_URL, Config.Endpoints.LIBRARY_FILES), limit);

        try {
            if (type != null) {
               url = appendParam(url, "type", type.toString());
            }
            if (source != null) {
                url = appendParam(url, "source", source.toString());
            }
            if (sortBy != null){
                url = appendParam(url, "sort_by", sortBy.toString());
            }
        }
        catch (UnsupportedEncodingException e) {
            throw new ConstantContactServiceException(e);
        }
  
        // Get REST response
        CUrlResponse response = getRestClient().get(url, accessToken);
        if (response.hasData()) {
          try {
              files = Component.resultSetFromJSON(response.getBody(), MyLibraryFile.class);
          }
          catch (ConstantContactComponentException e) {
              throw new ConstantContactServiceException(e);
          }
        }
        checkForResponseError(response, url);

        return files;           
    }
    
    /**
     * Retrieve Library Files By Folder API.<br/>
     * 
     * @param accessToken The Access Token for your user
     * @param folderId - The library Folder Id
     * @param limit - The number of results to return per page.
     * @return A {@link ResultSet} of {@link MyLibraryFile} in case of success; an exception is thrown otherwise.
     * @throws ConstantContactServiceException Thrown when :
     *             <ul>
     *             <li>something went wrong either on the client side;</li>
     *             <li>or an error message was received from the server side.</li>
     *             </ul>
     * <br/>
     *             To check if a detailed error message is present, call {@link ConstantContactException#hasErrorInfo()} <br/>
     *             Detailed error message (if present) can be seen by calling {@link ConstantContactException#getErrorInfo()}
     */
    public ResultSet<MyLibraryFile> getLibraryFilesByFolder(String accessToken, String folderId, Integer limit) throws ConstantContactServiceException{
        ResultSet<MyLibraryFile> files = null;
        
        // Construct access URL
        String url = paginateUrl(String.format("%1$s%2$s", Config.Endpoints.BASE_URL, String.format(Config.Endpoints.LIBRARY_FILES_BY_FOLDER, folderId)), limit);

        // Get REST response
        CUrlResponse response = getRestClient().get(url, accessToken);
        if (response.hasData()) {
          try {
              files = Component.resultSetFromJSON(response.getBody(), MyLibraryFile.class);
          }
          catch (ConstantContactComponentException e) {
              throw new ConstantContactServiceException(e);
          }
        }
        checkForResponseError(response, url);

        return files;           
    }
    
    /**
     * Get Library File API.<br/>
     * 
     * @param accessToken The Access Token for your user
     * @param fileId The ID for the File to return.
     * @return The added {@link MyLibraryFile}.
     * @throws ConstantContactServiceException Thrown when :
     *             <ul>
     *             <li>something went wrong either on the client side;</li>
     *             <li>or an error message was received from the server side.</li>
     *             </ul>
     * <br/>
     *             To check if a detailed error message is present, call {@link ConstantContactException#hasErrorInfo()} <br/>
     *             Detailed error message (if present) can be seen by calling {@link ConstantContactException#getErrorInfo()}
     */
    public MyLibraryFile getLibraryFile(String accessToken, String fileId) throws ConstantContactServiceException{
        MyLibraryFile file = null;

        String url = String.format("%1$s%2$s", Config.Endpoints.BASE_URL,
                String.format(Config.Endpoints.LIBRARY_FILE, fileId));

        // Get REST response
        CUrlResponse response = getRestClient().get(url, accessToken);
        if (response.hasData()) {
            try {
                file = Component.fromJSON(response.getBody(), MyLibraryFile.class);
            }
            catch (ConstantContactComponentException e) {
                throw new ConstantContactServiceException(e);
            }
        }
        checkForResponseError(response, url);

        return file;
    }
    
    /**
     * Update Library File API.<br/>
     * 
     * @param accessToken The Access Token for your user
     * @param file The Folder to update.
     * @param includePayload If the result should be the updated File or NULL (defaults to true if left null)
     * @return The added {@link MyLibraryFile}, or Null if includePayload was false.
     * @throws ConstantContactServiceException Thrown when :
     *             <ul>
     *             <li>something went wrong either on the client side;</li>
     *             <li>or an error message was received from the server side.</li>
     *             </ul>
     * <br/>
     *             To check if a detailed error message is present, call {@link ConstantContactException#hasErrorInfo()} <br/>
     *             Detailed error message (if present) can be seen by calling {@link ConstantContactException#getErrorInfo()}
     */ 
    public MyLibraryFile updateLibraryFile(String accessToken, MyLibraryFile file, Boolean includePayload) throws ConstantContactServiceException {
        MyLibraryFile updateFile = null;

        String url = String.format("%1$s%2$s", Config.Endpoints.BASE_URL,
                String.format(Config.Endpoints.LIBRARY_FILE, file.getId()));
        String json;
        try {
            json = file.toJSON();
        }
        catch (ConstantContactComponentException e) {
            throw new ConstantContactServiceException(e);
        }

        CUrlResponse response = getRestClient().put(url, accessToken, json);
        if (response.hasData()) {
            try {
                updateFile = Component.fromJSON(response.getBody(), MyLibraryFile.class);
            }
            catch (ConstantContactComponentException e) {
                throw new ConstantContactServiceException(e);
            }
        }
        checkForResponseError(response, url);

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
     * @throws ConstantContactServiceException Thrown when :
     *             <ul>
     *             <li>something went wrong either on the client side;</li>
     *             <li>or an error message was received from the server side.</li>
     *             </ul>
     * <br/>
     *             To check if a detailed error message is present, call {@link ConstantContactException#hasErrorInfo()} <br/>
     *             Detailed error message (if present) can be seen by calling {@link ConstantContactException#getErrorInfo()}
     */
    public void deleteLibraryFile(String accessToken, String fileId) throws ConstantContactServiceException {
        String url = String.format("%1$s%2$s", Config.Endpoints.BASE_URL,
                String.format(Config.Endpoints.LIBRARY_FILE, fileId));

        // Get REST response
        CUrlResponse response = getRestClient().delete(url, accessToken);
        checkForResponseError(response, url);

        return;   
    }
    
    /**
     * Retrieves the Status of files uploaded to the Library <br />
     * 
     * @param accessToken The Access Token for your user
     * @param fileId A varargs list of fileIds to return results for.
     * @throws {@link ConstantContactServiceException} When something went wrong
     *         in the Constant Contact flow or an error is returned from server.
     * @return The {@link List} of {@link UploadStatus} Data
     */
    public List<UploadStatus> getLibraryFilesUploadStatus(String accessToken, String ... fileId) throws ConstantContactServiceException {
        
        List<UploadStatus> uploadStatuses = null;
        
        StringBuffer filesToGet = new StringBuffer();
        
        filesToGet.append(fileId[0]);
        for (int i=1;i<fileId.length;i++){
            filesToGet.append(",");
            filesToGet.append(fileId[i]);
        }
     
        String url = String.format("%1$s%2$s", Config.Endpoints.BASE_URL,
                String.format(Config.Endpoints.LIBRARY_FILE_UPLOAD_STATUS, filesToGet));
        
        // Get REST response
        CUrlResponse response = getRestClient().get(url, accessToken);
        
        if (response.hasData()) {
            try {
                uploadStatuses = Component.listFromJSON(response.getBody(), UploadStatus.class);
            }
            catch (ConstantContactComponentException e) {
                throw new ConstantContactServiceException(e);
            }
        }
        checkForResponseError(response, url);

        return uploadStatuses;
    }
    
    /**
     * Moves files from one folder to another <br />
     * 
     * @param accessToken The Access Token for your user
     * @param folderId The folder to put the files in
     * @param body The JSON body [an array of fileIds]
     * @throws {@link ConstantContactServiceException} When something went wrong
     *         in the Constant Contact flow or an error is returned from server.
     * @throws IllegalArgumentException Thrown when data validation failed due to incorrect / missing parameter values. <br/>
     *         The exception also contains a description of the cause.<br/>
     *         Error message is taken from one of the members of {@link Errors}
     * @return The {@link List} of {@link MoveResults} Data
     */
    public List<MoveResults> moveLibraryFiles(String accessToken, String folderId, String body) throws ConstantContactServiceException {

        List<MoveResults> movedResults = null;
     
        String url = String.format("%1$s%2$s", Config.Endpoints.BASE_URL,
                String.format(Config.Endpoints.LIBRARY_FILE_MOVE, folderId));
        
        // Get REST response
        CUrlResponse response = getRestClient().put(url, accessToken, body);
        
        if (response.hasData()) {
            try {
                movedResults = Component.listFromJSON(response.getBody(), MoveResults.class);
            }
            catch (ConstantContactComponentException e) {
                throw new ConstantContactServiceException(e);
            }
        }
        checkForResponseError(response, url);

        return movedResults;
    }
    
    private static void checkForResponseError(CUrlResponse response, String url) throws ConstantContactServiceException {
        if (response.isError()) {
            ConstantContactServiceException constantContactException = new ConstantContactServiceException(
                    ConstantContactServiceException.RESPONSE_ERR_SERVICE);
            response.getInfo().add(new CUrlRequestError("url", url));
            constantContactException.setErrorInfo(response.getInfo());
            throw constantContactException;
        }
    }
}
