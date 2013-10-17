package com.constantcontact.services.library;

import java.io.UnsupportedEncodingException;

import com.constantcontact.components.Component;
import com.constantcontact.components.generic.response.ResultSet;
import com.constantcontact.components.library.file.MyLibraryFile;
import com.constantcontact.components.library.folder.MyLibraryFolder;
import com.constantcontact.components.library.folder.MyLibraryFolder.FolderSortOptions;
import com.constantcontact.components.library.info.MyLibrarySummary;
import com.constantcontact.exceptions.ConstantContactException;
import com.constantcontact.exceptions.component.ConstantContactComponentException;
import com.constantcontact.exceptions.service.ConstantContactServiceException;
import com.constantcontact.services.base.BaseService;
import com.constantcontact.util.CUrlRequestError;
import com.constantcontact.util.CUrlResponse;
import com.constantcontact.util.Config;

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
        if (response.isError()) {
            ConstantContactServiceException constantContactException = new ConstantContactServiceException(
                    ConstantContactServiceException.RESPONSE_ERR_SERVICE);
            response.getInfo().add(new CUrlRequestError("url", url));
            constantContactException.setErrorInfo(response.getInfo());
            throw constantContactException;
        }

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
        if (response.isError()) {
            ConstantContactServiceException constantContactException = new ConstantContactServiceException(
                    ConstantContactServiceException.RESPONSE_ERR_SERVICE);
            response.getInfo().add(new CUrlRequestError("url", url));
            constantContactException.setErrorInfo(response.getInfo());
            throw constantContactException;
        }

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
            if (response.isError()) {
                ConstantContactServiceException constantContactException = new ConstantContactServiceException(
                        ConstantContactServiceException.RESPONSE_ERR_SERVICE);
                response.getInfo().add(new CUrlRequestError("url", url));
                constantContactException.setErrorInfo(response.getInfo());
                throw constantContactException;
            }

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
        if (response.isError()) {
            ConstantContactServiceException constantContactException = new ConstantContactServiceException(
                    ConstantContactServiceException.RESPONSE_ERR_SERVICE);
            response.getInfo().add(new CUrlRequestError("url", url));
            constantContactException.setErrorInfo(response.getInfo());
            throw constantContactException;
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
        if (response.isError()) {
            ConstantContactServiceException constantContactException = new ConstantContactServiceException(
                    ConstantContactServiceException.RESPONSE_ERR_SERVICE);
            response.getInfo().add(new CUrlRequestError("url", url));
            constantContactException.setErrorInfo(response.getInfo());
            throw constantContactException;
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
        if (response.isError()) {
            ConstantContactServiceException constantContactException = new ConstantContactServiceException(
                    ConstantContactServiceException.RESPONSE_ERR_SERVICE);
            response.getInfo().add(new CUrlRequestError("url", url));
            constantContactException.setErrorInfo(response.getInfo());
            throw constantContactException;
        }

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
          if (response.isError()) {
            ConstantContactServiceException constantContactException = new ConstantContactServiceException(
                ConstantContactServiceException.RESPONSE_ERR_SERVICE);
            response.getInfo().add(new CUrlRequestError("url", url));
            constantContactException.setErrorInfo(response.getInfo());
            throw constantContactException;
          }

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
        if (response.isError()) {
            ConstantContactServiceException constantContactException = new ConstantContactServiceException(
                    ConstantContactServiceException.RESPONSE_ERR_SERVICE);
            response.getInfo().add(new CUrlRequestError("url", url));
            constantContactException.setErrorInfo(response.getInfo());
            throw constantContactException;
        }

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
        if (response.isError()) {
          ConstantContactServiceException constantContactException = new ConstantContactServiceException(
              ConstantContactServiceException.RESPONSE_ERR_SERVICE);
          response.getInfo().add(new CUrlRequestError("url", url));
          constantContactException.setErrorInfo(response.getInfo());
          throw constantContactException;
        }

        return files;           
    }
}
