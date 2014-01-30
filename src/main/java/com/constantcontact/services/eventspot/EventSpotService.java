package com.constantcontact.services.eventspot;

import com.constantcontact.components.Component;
import com.constantcontact.components.eventspot.response.EventResponse;
import com.constantcontact.exceptions.service.ConstantContactServiceException;
import com.constantcontact.services.base.BaseService;
import com.constantcontact.util.CUrlRequestError;
import com.constantcontact.util.CUrlResponse;
import com.constantcontact.util.Config;

/**
 * @author Stefan Halus <stefan.halus@osf-global.com>
 */
public class EventSpotService extends BaseService implements IEventSpotService {


    public EventResponse getEvent(String accessToken, String eventId) throws
            ConstantContactServiceException {
        EventResponse event = null;
        try {
            String url = String.format("%1$s%2$s", Config.Endpoints.BASE_URL,
                    String.format(Config.Endpoints.EVENTSPOT_ID, eventId));

            CUrlResponse response = getRestClient().get(url, accessToken);

            if (response.hasData()) {
                event = Component.fromJSON(response.getBody(), EventResponse.class);
            }
            if (response.isError()) {
                ConstantContactServiceException constantContactException = new ConstantContactServiceException(
                        ConstantContactServiceException.RESPONSE_ERR_SERVICE);
                response.getInfo().add(new CUrlRequestError("url", url));
                constantContactException.setErrorInfo(response.getInfo());
                throw constantContactException;
            }
        } catch (ConstantContactServiceException e) {
            throw new ConstantContactServiceException(e);
        } catch (Exception e) {
            throw new ConstantContactServiceException(e);
        }
        return event;
    }

    /**
     * Default constructor.
     */
    public EventSpotService() {
        super();
    }
}
