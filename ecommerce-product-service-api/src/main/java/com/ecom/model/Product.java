package com.ecom.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "PCODE", nullable = false)
	private String productCode;

	@Column(name = "NAME", nullable = false)
	private String productName;

	@Column(name = "SHORT_DESCRIPTION", nullable = false)
	private String shortDescription;

	@Column(name = "LONG_DESCRIPTION", nullable = false)
	private String longDescription;

	@Column(name = "CANDISPLAY", nullable = false)
	private boolean canDisplay;

	@Column(name = "ISDELETED", nullable = false)
	private boolean isDeleted;

	@Column(name = "ISAUTOMOTIVE", nullable = false)
	private boolean isAutomotive;

	@Column(name = "ISINTERNATIONAL", nullable = false)
	private boolean isInternational;

	@OneToOne
	@JoinColumn(name = "parent_category_id")
	private Category parentCategory;

	@OneToOne
	@JoinColumn(name = "category_id")
	private Category category;

}
