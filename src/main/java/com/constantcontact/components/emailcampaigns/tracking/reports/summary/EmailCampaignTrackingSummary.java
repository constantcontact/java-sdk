package com.constantcontact.components.emailcampaigns.tracking.reports.summary;

import java.io.Serializable;

import com.constantcontact.components.Component;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents a single Email Campaign Tracking Summary for the Email Campaign Tracking Service in Constant Contact.<br/>
 * A summary just holds counters. For more detailed info, you should call specific API for each counter.
 * 
 * @author ConstantContact
 */
public class EmailCampaignTrackingSummary extends Component implements Serializable {

	/**
	 * Serial version unique identifier.
	 */
	private static final long serialVersionUID = 7952567590641877914L;

	@JsonIgnore
	private int unsubscribes;

	@JsonIgnore
	private int clicks;

	@JsonIgnore
	private int opens;

	@JsonIgnore
	private int bounces;

	@JsonIgnore
	private int sends;

	@JsonIgnore
	private int forwards;

	/**
	 * Get the Unsubscribes
	 * 
	 * @return The Unsubscribes
	 */
	@JsonProperty("unsubscribes")
	public int getUnsubscribes() {
		return unsubscribes;
	}

	/**
	 * Get the Clicks
	 * 
	 * @return The Clicks
	 */
	@JsonProperty("clicks")
	public int getClicks() {
		return clicks;
	}

	/**
	 * Get the Opens
	 * 
	 * @return The Opens
	 */
	@JsonProperty("opens")
	public int getOpens() {
		return opens;
	}

	/**
	 * Get the Bounces
	 * 
	 * @return The Bounces
	 */
	@JsonProperty("bounces")
	public int getBounces() {
		return bounces;
	}

	/**
	 * Get the Sends
	 * 
	 * @return The Sends
	 */
	@JsonProperty("sends")
	public int getSends() {
		return sends;
	}

	/**
	 * Get the Forwards
	 * 
	 * @return The Forwards
	 */
	@JsonProperty("forwards")
	public int getForwards() {
		return forwards;
	}

	/**
	 * Set the Unsubscribes
	 * 
	 * @param unsubscribes The Unsubscribes
	 */
	public void setUnsubscribes(int unsubscribes) {
		this.unsubscribes = unsubscribes;
	}

	/**
	 * Set the Clicks
	 * 
	 * @param clicks The Clicks
	 */
	public void setClicks(int clicks) {
		this.clicks = clicks;
	}

	/**
	 * Set the Opens
	 * 
	 * @param opens The Opens
	 */
	public void setOpens(int opens) {
		this.opens = opens;
	}

	/**
	 * Set the Bounces
	 * 
	 * @param bounces The Bounces
	 */
	public void setBounces(int bounces) {
		this.bounces = bounces;
	}

	/**
	 * Set the Sends
	 * 
	 * @param sends The Sends
	 */
	public void setSends(int sends) {
		this.sends = sends;
	}

	/**
	 * Set the Forwards
	 * 
	 * @param forwards The Forwards
	 */
	public void setForwards(int forwards) {
		this.forwards = forwards;
	}

	/**
	 * Default constructor.
	 */
	public EmailCampaignTrackingSummary() {
		super();
	}

	/**
	 * Custom implementation for {@link Object#toString()}.
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EmailCampaignTrackingSummary [unsubscribes=");
		builder.append(unsubscribes);
		builder.append(", clicks=");
		builder.append(clicks);
		builder.append(", opens=");
		builder.append(opens);
		builder.append(", bounces=");
		builder.append(bounces);
		builder.append(", sends=");
		builder.append(sends);
		builder.append(", forwards=");
		builder.append(forwards);
		builder.append("]");
		return builder.toString();
	}
}
