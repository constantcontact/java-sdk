package com.constantcontact.services.library;

import com.constantcontact.components.generic.response.ResultSet;
import com.constantcontact.components.library.file.MyLibraryFile;
import com.constantcontact.components.library.folder.MyLibraryFolder;
import com.constantcontact.components.library.folder.MyLibraryFolder.FolderSortOptions;
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
     * @return The {@link ResultSet} of {@link MyLibraryFolder} Data
     */
    public ResultSet<MyLibraryFolder> getLibraryFolders(String accessToken, MyLibraryFolder.FolderSortOptions sortBy, Integer limit) throws ConstantContactServiceException;
    
    /**
     * Add Library Folder API.<br/>
     * 
     * @param accessToken The Access Token for your user
     * @param folder The {@link MyLibraryFolder} to add.
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
    public MyLibraryFolder addLibraryFolder(String accessToken, MyLibraryFolder folder) throws ConstantContactServiceException;

    /**
     * Get Library Folder API.<br/>
     * 
     * @param accessToken The Access Token for your user
     * @param folderId The ID for the Folder to return.
     * @return The added {@link MyLibraryFolder}.
     * @throws ConstantContactServiceException Thrown when :
     *             <ul>
     *             <li>something went wrong either on the client side;</li>
     *             <li>or an error message was received from the server side.</li>
     *             </ul>
     * <br/>
     *             To check if a detailed error message is present, call {@link ConstantContactException#hasErrorInfo()} <br/>
     *             Detailed error message (if present) can be seen by calling {@link ConstantContactException#getErrorInfo()}
     */
    public MyLibraryFolder getLibraryFolder(String accessToken, String folderId) throws ConstantContactServiceException;
    
    /**
     * Update Library Folder API.<br/>
     * 
     * @param accessToken The Access Token for your user
     * @param folder The Folder to update.
     * @param includePayload If the result should be the updated Folder or NULL (defaults to true if left null)
     * @return The added {@link MyLibraryFolder}, or Null if includePayload was false.
     * @throws ConstantContactServiceException Thrown when :
     *             <ul>
     *             <li>something went wrong either on the client side;</li>
     *             <li>or an error message was received from the server side.</li>
     *             </ul>
     * <br/>
     *             To check if a detailed error message is present, call {@link ConstantContactException#hasErrorInfo()} <br/>
     *             Detailed error message (if present) can be seen by calling {@link ConstantContactException#getErrorInfo()}
     */ 
    public MyLibraryFolder updateLibraryFolder(String accessToken, MyLibraryFolder folder, Boolean includePayload) throws ConstantContactServiceException;
    
    /**
     * Delete Library Folder API.<br/>
     * 
     * @param accessToken The Access Token for your user
     * @param folderId The ID for the Folder to delete.
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
    public void deleteLibraryFolder(String accessToken, String folderId) throws ConstantContactServiceException;
        
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
    public ResultSet<MyLibraryFile> getLibraryTrash(String accessToken, MyLibraryFile.Type type, MyLibraryFile.SortBy sortBy, Integer limit) throws ConstantContactServiceException;

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
    public void deleteLibraryTrash(String accessToken) throws ConstantContactServiceException;
    
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
    public ResultSet<MyLibraryFile> getLibraryFiles(String accessToken, MyLibraryFile.Type type, MyLibraryFile.Source source, MyLibraryFile.SortBy sortBy, Integer limit) throws ConstantContactServiceException;
    
    /**
     * Retrieve Library Files By Folder API.<br/>
     * 
     * @param accessToken The Access Token for your user
     * @param folderId - The library Folder Id
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
    public ResultSet<MyLibraryFile> getLibraryFilesByFolder(String accessToken, String folderId, MyLibraryFile.Type type, MyLibraryFile.Source source, MyLibraryFile.SortBy sortBy, Integer limit) throws ConstantContactServiceException;
    
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
    public MyLibraryFile getLibraryFile(String accessToken, String fileId) throws ConstantContactServiceException;
    
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
    public MyLibraryFile updateLibraryFile(String accessToken, MyLibraryFile file, Boolean includePayload) throws ConstantContactServiceException;
}
