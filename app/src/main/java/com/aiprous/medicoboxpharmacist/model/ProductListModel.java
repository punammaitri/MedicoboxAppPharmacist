package com.aiprous.medicoboxpharmacist.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ProductListModel {

    @Expose
    @SerializedName("qty")
    private String qty;
    @Expose
    @SerializedName("required_options")
    private String requiredOptions;
    @Expose
    @SerializedName("has_options")
    private String hasOptions;
    @Expose
    @SerializedName("sku")
    private String sku;
    @Expose
    @SerializedName("type_id")
    private String typeId;
    @Expose
    @SerializedName("attribute_set_id")
    private String attributeSetId;
    @Expose
    @SerializedName("entity_id")
    private String entityId;


    public ProductListModel(String qty, String requiredOptions, String hasOptions, String sku, String typeId,
                            String attributeSetId, String entityId) {
        this.qty = qty;
        this.requiredOptions = requiredOptions;
        this.hasOptions = hasOptions;
        this.sku = sku;
        this.typeId = typeId;
        this.attributeSetId = attributeSetId;
        this.entityId = entityId;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getRequiredOptions() {
        return requiredOptions;
    }

    public void setRequiredOptions(String requiredOptions) {
        this.requiredOptions = requiredOptions;
    }

    public String getHasOptions() {
        return hasOptions;
    }

    public void setHasOptions(String hasOptions) {
        this.hasOptions = hasOptions;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getAttributeSetId() {
        return attributeSetId;
    }

    public void setAttributeSetId(String attributeSetId) {
        this.attributeSetId = attributeSetId;
    }

    public String getEntityId() {
        return entityId;
    }

    public void setEntityId(String entityId) {
        this.entityId = entityId;
    }
}
