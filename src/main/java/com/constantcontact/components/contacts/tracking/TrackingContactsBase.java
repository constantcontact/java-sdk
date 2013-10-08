package com.constantcontact.components.contacts.tracking;

import com.constantcontact.components.common.tracking.TrackingBase;
import com.constantcontact.components.contacts.tracking.bounces.ContactTrackingBounce;
import com.constantcontact.components.contacts.tracking.clicks.ContactTrackingClick;
import com.constantcontact.components.contacts.tracking.forwards.ContactTrackingForward;
import com.constantcontact.components.contacts.tracking.opens.ContactTrackingOpen;
import com.constantcontact.components.contacts.tracking.sends.ContactTrackingSend;
import com.constantcontact.components.contacts.tracking.unsubscribes.ContactTrackingUnsubscribe;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "activity_type")
    @JsonSubTypes({
      @Type(value = ContactTrackingBounce.class, name = "EMAIL_BOUNCE"),
      @Type(value = ContactTrackingClick.class, name = "EMAIL_CLICK"),
      @Type(value = ContactTrackingForward.class, name = "EMAIL_FORWARD"),
      @Type(value = ContactTrackingOpen.class, name = "EMAIL_OPEN"),
      @Type(value = ContactTrackingSend.class, name = "EMAIL_SEND"),
      @Type(value = ContactTrackingUnsubscribe.class, name = "EMAIL_UNSUBSCRIBE")})
public class TrackingContactsBase extends TrackingBase {

}
