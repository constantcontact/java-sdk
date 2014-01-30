package com.constantcontact.services.eventspot;

import com.constantcontact.components.eventspot.response.EventResponse;
import com.constantcontact.exceptions.service.ConstantContactServiceException;
import com.constantcontact.services.base.IBaseService;

/**
 * @author Stefan Halus <stefan.halus@osf-global.com>
 */
public interface IEventSpotService extends IBaseService {

    //Todo documentation
    public EventResponse getEvent(String accessToken, String eventId) throws ConstantContactServiceException;
}
