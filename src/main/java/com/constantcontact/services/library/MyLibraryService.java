package com.constantcontact.services.library;

import com.constantcontact.components.Component;
import com.constantcontact.components.generic.response.ResultSet;
import com.constantcontact.components.library.file.ImageSource;
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
import com.constantcontact.util.RawApiResponse;
import com.constantcontact.util.Config;
import com.constantcontact.util.ConstantContactExceptionFactory;
import com.constantcontact.util.http.MultipartBody;

import java.io.UnsupportedEncodingException;
import java.util.List;

public class MyLibraryService extends BaseService implements IMyLibraryService {

	private String accessToken;
	private String apiKey;
	
    /**
	 * @return the accessToken
	 */
	public String getAccessToken() {
		return accessToken;
	}

	/**
	 * @param accessToken the accessToken to set
	 */
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	/**
	 * @return the apiKey
	 */
	public String getApiKey() {
		return apiKey;
	}

	/**
	 * @param apiKey the apiKey to set
	 */
	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	/**
     * Retrieves the information for the MyLibrary product for this account
     * 
     *            The Access Token for your user
     * @throws {@link ConstantContactServiceException} When something went wrong
     *         in the Constant Contact flow or an error is returned from server.
     * @return The {@link MyLibrarySummary} Data
     */
    public MyLibrarySummary getLibraryInfo() throws ConstantContactServiceException {

        MyLibrarySummary summary = null;

        String url = String.format("%1$s%2$s", Config.instance().getBaseUrl(), Config.instance().getLibraryInfo());
        RawApiResponse response = getRestClient().get(url);

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
     * @param sortBy
     *            The method to sort by. See {@link FolderSortOptions}. Leave
     *            null to not use
     * @param limit
     *            The number of results to return. Leave null to use default.
     * @throws {@link ConstantContactServiceException} When something went wrong
     *         in the Constant Contact flow or an error is returned from server.
     * @return The {@link ResultSet} of {@link MyLibraryFolder} Data
     */
    public ResultSet<MyLibraryFolder> getLibraryFolders(MyLibraryFolder.FolderSortOptions sortBy, Integer limit)
            throws ConstantContactServiceException {
        ResultSet<MyLibraryFolder> folders = null;

        // Construct access URL
        String url = paginateUrl(
                String.format("%1$s%2$s", Config.instance().getBaseUrl(), Config.instance().getLibraryFolders()), limit);

        if (sortBy != null) {
            try {
                url = appendParam(url, "sort_by", sortBy.toString());
            }
            catch (UnsupportedEncodingException e) {
                throw new ConstantContactServiceException(e);
            }
        }

        // Get REST response
        RawApiResponse response = getRestClient().get(url);
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
    public MyLibraryFolder addLibraryFolder(MyLibraryFolder folder) throws ConstantContactServiceException {
    	
	    if (folder == null){
	        throw new IllegalArgumentException(Config.instance().getErrorFolderNull());
	    }
	    
        MyLibraryFolder newFolder = null;
        try {
            String url = String.format("%1$s%2$s", Config.instance().getBaseUrl(), Config.instance().getLibraryFolders());
            String json = folder.toJSON();

            RawApiResponse response = getRestClient().post(url, json);
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
    public MyLibraryFolder getLibraryFolder(String folderId) throws ConstantContactServiceException {
    	
    	if (folderId == null || folderId.trim().equals("")){
	        throw new IllegalArgumentException(Config.instance().getErrorFolderIdNull());
	    }
    	
        MyLibraryFolder folder = null;

        String url = String.format("%1$s%2$s", Config.instance().getBaseUrl(),
                String.format(Config.instance().getLibraryFolder(), folderId));

        // Get REST response
        RawApiResponse response = getRestClient().get(url);
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
    public MyLibraryFolder updateLibraryFolder(MyLibraryFolder folder, Boolean includePayload)
            throws ConstantContactServiceException {

    	if (folder == null || folder.getId() == null || folder.getId().trim().equals("")){
            throw new IllegalArgumentException(Config.instance().getErrorFolderIdNull());
        }
    	
        MyLibraryFolder updateFolder = null;

        String url = String.format("%1$s%2$s", Config.instance().getBaseUrl(),
                String.format(Config.instance().getLibraryFolder(), folder.getId()));
        String json;
        try {
            json = folder.toJSON();
        }
        catch (ConstantContactComponentException e) {
            throw new ConstantContactServiceException(e);
        }

        RawApiResponse response = getRestClient().put(url, json);
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
    public void deleteLibraryFolder(String folderId) throws ConstantContactServiceException {
    	
    	 if (folderId == null || folderId.trim().equals("")){
             throw new IllegalArgumentException(Config.instance().getErrorFolderIdNull());
         }
    	 
        String url = String.format("%1$s%2$s", Config.instance().getBaseUrl(),
                String.format(Config.instance().getLibraryFolder(), folderId));

        // Get REST response
        RawApiResponse response = getRestClient().delete(url);
        checkForResponseError(response, url);

        return;
    }
    
    /**
     * Retrieve Library Trash API.<br/>
     * 
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
    public ResultSet<MyLibraryFile> getLibraryTrash(MyLibraryFile.Type type, MyLibraryFile.SortBy sortBy, Integer limit) throws ConstantContactServiceException{
        ResultSet<MyLibraryFile> files = null;
        
          // Construct access URL
          String url = paginateUrl(String.format("%1$s%2$s", Config.instance().getBaseUrl(), Config.instance().getLibraryFolderTrash()), limit);

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
          RawApiResponse response = getRestClient().get(url);
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
    public void deleteLibraryTrash() throws ConstantContactServiceException{
        String url = String.format("%1$s%2$s", Config.instance().getBaseUrl(), Config.instance().getLibraryFolderTrash());

        // Get REST response
        RawApiResponse response = getRestClient().delete(url);
        checkForResponseError(response, url);

        return;
    }
    
    /**
     * Retrieve Library File API.<br/>
     * 
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
    public ResultSet<MyLibraryFile> getLibraryFiles(MyLibraryFile.Type type, ImageSource source, MyLibraryFile.SortBy sortBy, Integer limit) throws ConstantContactServiceException{
        ResultSet<MyLibraryFile> files = null;
        
        // Construct access URL
        String url = paginateUrl(String.format("%1$s%2$s", Config.instance().getBaseUrl(), Config.instance().getLibraryFiles()), limit);

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
        RawApiResponse response = getRestClient().get(url);
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
    public ResultSet<MyLibraryFile> getLibraryFilesByFolder(String folderId, Integer limit) throws ConstantContactServiceException{
        ResultSet<MyLibraryFile> files = null;
        
        // Construct access URL
        String url = paginateUrl(String.format("%1$s%2$s", Config.instance().getBaseUrl(), String.format(Config.instance().getLibraryFilesByFolder(), folderId)), limit);

        // Get REST response
        RawApiResponse response = getRestClient().get(url);
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
    public MyLibraryFile getLibraryFile(String fileId) throws ConstantContactServiceException{
    	
        if (fileId == null || fileId.trim().equals("")){
            throw new IllegalArgumentException(Config.instance().getErrorFileIdNull());
        }
        
        MyLibraryFile file = null;

        String url = String.format("%1$s%2$s", Config.instance().getBaseUrl(),
                String.format(Config.instance().getLibraryFile(), fileId));

        // Get REST response
        RawApiResponse response = getRestClient().get(url);
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
    public MyLibraryFile updateLibraryFile(MyLibraryFile file, Boolean includePayload) throws ConstantContactServiceException {
    	
        if (file == null || file.getId() == null || file.getId().trim().equals("")){
            throw new IllegalArgumentException(Config.instance().getErrorFileIdNull());
        }
        
        MyLibraryFile updateFile = null;

        String url = String.format("%1$s%2$s", Config.instance().getBaseUrl(),
                String.format(Config.instance().getLibraryFile(), file.getId()));
        String json;
        try {
            json = file.toJSON();
        }
        catch (ConstantContactComponentException e) {
            throw new ConstantContactServiceException(e);
        }

        RawApiResponse response = getRestClient().put(url, json);
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
    public void deleteLibraryFile(String fileId) throws ConstantContactServiceException {
    	
    	if (fileId == null || fileId.trim().equals("")){
            throw new IllegalArgumentException(Config.instance().getErrorFileIdNull());
        }
    	
        String url = String.format("%1$s%2$s", Config.instance().getBaseUrl(),
                String.format(Config.instance().getLibraryFile(), fileId));

        // Get REST response
        RawApiResponse response = getRestClient().delete(url);
        checkForResponseError(response, url);

        return;   
    }
    
    /**
     * Retrieves the Status of files uploaded to the Library <br />
     * 
     * @param fileId A varargs list of fileIds to return results for.
     * @throws {@link ConstantContactServiceException} When something went wrong
     *         in the Constant Contact flow or an error is returned from server.
     * @return The {@link List} of {@link UploadStatus} Data
     */
    public List<UploadStatus> getLibraryFilesUploadStatus(String ... fileId) throws ConstantContactServiceException {
        
    	if (fileId == null || fileId.length < 1){
            throw new IllegalArgumentException(Config.instance().getErrorFileIdNull());
        }
    	
        List<UploadStatus> uploadStatuses = null;
        
        StringBuffer filesToGet = new StringBuffer();
        
        filesToGet.append(fileId[0]);
        for (int i=1;i<fileId.length;i++){
            filesToGet.append(",");
            filesToGet.append(fileId[i]);
        }
     
        String url = String.format("%1$s%2$s", Config.instance().getBaseUrl(),
                String.format(Config.instance().getLibraryFileUploadStatus(), filesToGet));
        
        // Get REST response
        RawApiResponse response = getRestClient().get(url);
        
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
     * @param folderId The folder to put the files in
     * @param body The JSON body [an array of fileIds]
     * @throws {@link ConstantContactServiceException} When something went wrong
     *         in the Constant Contact flow or an error is returned from server.
     * @throws IllegalArgumentException Thrown when data validation failed due to incorrect / missing parameter values. <br/>
     *         The exception also contains a description of the cause.<br/>
     *         Error message is taken from one of the members of {@link Errors}
     * @return The {@link List} of {@link MoveResults} Data
     */
    public List<MoveResults> moveLibraryFiles(String folderId, String body) throws ConstantContactServiceException {

    	if (folderId == null || folderId.trim().equals("")){
            throw new IllegalArgumentException(Config.instance().getErrorFolderIdNull());
        }
    	
        List<MoveResults> movedResults = null;
     
        String url = String.format("%1$s%2$s", Config.instance().getBaseUrl(),
                String.format(Config.instance().getLibraryFileMove(), folderId));
        
        // Get REST response
        RawApiResponse response = getRestClient().put(url, body);
        
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
    
    /**
     * Adds a file to the library <br />
     * @param  request The {@link MultipartBody} to upload
     * @return The fileId associated with the uploaded file
     * @throws {@link ConstantContactServiceException} When something went wrong
     *         in the Constant Contact flow or an error is returned from server.
     */
    public String addLibraryFile(MultipartBody request) throws ConstantContactServiceException {

    	if (request == null) {
			throw new IllegalArgumentException(Config.instance().getErrorFileNull());
		}
    	
        String url = Config.instance().getBaseUrl() + Config.instance().getLibraryFiles();
        RawApiResponse response = getRestClient().postMultipart(url, request);

        checkForResponseError(response, url);

        // The Header structure supports more than one value for each header.
        // Location only has one.
        List<String> locationHeaders = response.getHeaders().get("Location");
        
        String folderURI = locationHeaders.get(0);
        int folderIdStart = folderURI.lastIndexOf("/") + 1;
        String folderId = folderURI.substring(folderIdStart);
        return folderId; 
    }
    
    private static void checkForResponseError(RawApiResponse response, String url) throws ConstantContactServiceException {
        if (response.isError()) {
            throw ConstantContactExceptionFactory.createServiceException(response, url);
        }
    }
    
    public MyLibraryService(String accessToken, String apiKey) {
    	super(accessToken, apiKey);
    	this.setAccessToken(accessToken);
    	this.setApiKey(apiKey);
    }
}
