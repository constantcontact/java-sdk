package com.constantcontact.services.library;

import com.constantcontact.components.library.info.MyLibrarySummary;
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
    
}
