package com.constantcontact.services.library;

import java.io.UnsupportedEncodingException;

import com.constantcontact.components.Component;
import com.constantcontact.components.generic.response.ResultSet;
import com.constantcontact.components.library.folder.Folder;
import com.constantcontact.components.library.folder.Folder.FolderSortOptions;
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
     * @return The {@link ResultSet} of {@link Folder} Data
     */
    public ResultSet<Folder> getLibraryFolders(String accessToken, Folder.FolderSortOptions sortBy, Integer limit)
            throws ConstantContactServiceException {
        ResultSet<Folder> folders = null;

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
                folders = Component.resultSetFromJSON(response.getBody(), Folder.class);
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
     *            The {@link Folder} to add.
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
    public Folder addLibraryFolder(String accessToken, Folder folder) throws ConstantContactServiceException {
        Folder newFolder = null;
        try {
            String url = String.format("%1$s%2$s", Config.Endpoints.BASE_URL, Config.Endpoints.LIBRARY_FOLDERS);
            String json = folder.toJSON();

            CUrlResponse response = getRestClient().post(url, accessToken, json);
            if (response.hasData()) {
                newFolder = Component.fromJSON(response.getBody(), Folder.class);

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
     * @param folderId The ID for the Folder to return.
     * @return The added {@link Folder}.
     * @throws ConstantContactServiceException Thrown when :
     *             <ul>
     *             <li>something went wrong either on the client side;</li>
     *             <li>or an error message was received from the server side.</li>
     *             </ul>
     * <br/>
     *             To check if a detailed error message is present, call {@link ConstantContactException#hasErrorInfo()} <br/>
     *             Detailed error message (if present) can be seen by calling {@link ConstantContactException#getErrorInfo()}
     */
    public Folder getLibraryFolder(String accessToken, String folderId) throws ConstantContactServiceException{
        Folder folder = null;
        
        String url = String.format("%1$s%2$s", Config.Endpoints.BASE_URL, String.format(Config.Endpoints.LIBRARY_FOLDER, folderId));
        
        // Get REST response
        CUrlResponse response = getRestClient().get(url, accessToken);
        if (response.hasData()) {
            try {
                folder = Component.fromJSON(response.getBody(), Folder.class);
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
}
