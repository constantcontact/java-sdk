package com.constantcontact.components.activities.contacts.request;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.constantcontact.components.Component;
import com.constantcontact.services.activities.BulkActivitiesService;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Export Contacts Request for the Bulk Activities in Constant Contact.
 * 
 * @see BulkActivitiesService
 * @author ConstantContact
 * 
 */
public class ExportContactsRequest extends Component implements Serializable {

	/**
	 * Serial version unique identifier.
	 */
	private static final long serialVersionUID = 5729422820832008970L;
	
	/**
	 * CSV file type for the exported data.
	 */
	public static final String FILE_TYPE_CSV = "CSV";
	
	/**
	 * Sort by email address specifier on exported data.
	 */	
	public static final String SORT_BY_EMAIL_ADDRESS = "EMAIL_ADDRESS";
	
	/**
	 * Sort descending by date specifier on exported data.
	 */		
	public static final String SORT_BY_DATE_DESC = "DATE_DESC";

	@JsonIgnore
	private String fileType;

	@JsonIgnore
	private String sortBy;

	@JsonIgnore
	private boolean exportDateAdded;

	@JsonIgnore
	private boolean exportAddedBy;

	@JsonIgnore
	private List<String> lists;

	@JsonIgnore
	private List<String> columnNames;

	/**
	 * Get the File Type
	 * 
	 * @return The File Type
	 */
	@JsonProperty("file_type")
	public String getFileType() {
		return fileType;
	}

	/**
	 * Get the Sort By
	 * 
	 * @return The Sort By
	 */
	@JsonProperty("sort_by")
	public String getSortBy() {
		return sortBy;
	}

	/**
	 * Get the Export Date Added
	 * 
	 * @return The Export Date Added
	 */
	@JsonProperty("export_date_added")
	public boolean isExportDateAdded() {
		return exportDateAdded;
	}

	/**
	 * Get the Export Added By
	 * 
	 * @return The Export Added By
	 */
	@JsonProperty("export_added_by")
	public boolean isExportAddedBy() {
		return exportAddedBy;
	}

	/**
	 * Get the Lists
	 * 
	 * @return The Lists
	 */
	@JsonProperty("lists")
	public List<String> getLists() {
		return lists;
	}

	/**
	 * Get the Column Names
	 * 
	 * @return The Column Names
	 */
	@JsonProperty("column_names")
	public List<String> getColumnNames() {
		return columnNames;
	}

	/**
	 * Set the File Type
	 * 
	 * @param fileType The new File Type
	 */
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	/**
	 * Set the Sort By
	 * 
	 * @param sortBy The new Sort By
	 */
	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}

	/**
	 * Set the Export Date Added
	 * 
	 * @param exportDateAdded The new Export Date Added
	 */
	public void setExportDateAdded(boolean exportDateAdded) {
		this.exportDateAdded = exportDateAdded;
	}

	/**
	 * Set the Export Added By
	 * 
	 * @param exportAddedBy The new Export Added By
	 */
	public void setExportAddedBy(boolean exportAddedBy) {
		this.exportAddedBy = exportAddedBy;
	}

	/**
	 * Set the Lists
	 * 
	 * @param lists The new Lists
	 */
	public void setLists(List<String> lists) {
		this.lists = lists;
	}

	/**
	 * Set the Column Names
	 * 
	 * @param columnNames The new Column Names
	 */
	public void setColumnNames(List<String> columnNames) {
		this.columnNames = columnNames;
	}

	/**
	 * Default constructor.
	 */
	public ExportContactsRequest() {
		super();
		setLists(new ArrayList<String>());
		setColumnNames(new ArrayList<String>());
	}

	/**
	 * Custom implementation for {@link Object#toString()}.
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ExportContactsRequest [fileType=");
		builder.append(fileType);
		builder.append(", sortBy=");
		builder.append(sortBy);
		builder.append(", exportDateAdded=");
		builder.append(exportDateAdded);
		builder.append(", exportAddedBy=");
		builder.append(exportAddedBy);
		builder.append(", lists=");
		builder.append(lists);
		builder.append(", columnNames=");
		builder.append(columnNames);
		builder.append("]");
		return builder.toString();
	}
}
