package com.constantcontact.services.library;

import com.constantcontact.components.generic.response.ResultSet;
import com.constantcontact.components.library.folder.Folder;
import com.constantcontact.components.library.folder.Folder.FolderSortOptions;
import com.constantcontact.components.library.info.MyLibrarySummary;
import com.constantcontact.exceptions.ConstantContactException;
import com.constantcontact.exceptions.service.ConstantContactServiceException;
import com.constantcontact.services.base.IBaseService;

public interface IMyLibraryService extends IBaseService {

    /**
     * Retrieves the information for the MyLibrary product for this account
     * 
     * @param accessToken The Access Token for your user
     * @throws {@link ConstantContactServiceException}  When something went wrong in the Constant Contact flow or an error is returned from server.
     * @return The {@link MyLibrarySummary} Data
     */
    public MyLibrarySummary getLibraryInfo(String accessToken) throws ConstantContactServiceException;

    /**
     * Retrieves the list of folders
     * 
     * @param accessToken
     *            The Access Token for your user
     * @param sortBy The method to sort by. See {@link FolderSortOptions}. Leave null to not use
     * @param limit The number of results to return. Leave null to use default.
     * @throws {@link ConstantContactServiceException} When something went wrong
     *         in the Constant Contact flow or an error is returned from server.
     * @return The {@link ResultSet} of {@link Folder} Data
     */
    public ResultSet<Folder> getLibraryFolders(String accessToken, Folder.FolderSortOptions sortBy, Integer limit) throws ConstantContactServiceException;
    
    /**
     * Add Library Folder API.<br/>
     * 
     * @param accessToken The Access Token for your user
     * @param folder The {@link Folder} to add.
     * @return The added Folder.
     * @throws ConstantContactServiceException Thrown when :
     *             <ul>
     *             <li>something went wrong either on the client side;</li>
     *             <li>or an error message was received from the server side.</li>
     *             </ul>
     * <br/>
     *             To check if a detailed error message is present, call {@link ConstantContactException#hasErrorInfo()} <br/>
     *             Detailed error message (if present) can be seen by calling {@link ConstantContactException#getErrorInfo()}
     */
    public Folder addLibraryFolder(String accessToken, Folder folder) throws ConstantContactServiceException;
    
}
