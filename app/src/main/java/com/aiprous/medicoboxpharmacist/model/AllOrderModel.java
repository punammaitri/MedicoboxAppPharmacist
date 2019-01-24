package com.aiprous.medicoboxpharmacist.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public abstract class AllOrderModel {
    @Expose
    @SerializedName("completed")
    public ArrayList<Completed> completed;
    @Expose
    @SerializedName("canceled")
    public ArrayList<Canceled> canceled;
    @Expose
    @SerializedName("pending")
    public ArrayList<Pending> pending;
    @Expose
    @SerializedName("processing")
    public ArrayList<Processing> processing;


    public ArrayList<Completed> getCompleted() {
        return completed;
    }

    public void setCompleted(ArrayList<Completed> completed) {
        this.completed = completed;
    }

    public ArrayList<Canceled> getCanceled() {
        return canceled;
    }

    public void setCanceled(ArrayList<Canceled> canceled) {
        this.canceled = canceled;
    }

    public ArrayList<Pending> getPending() {
        return pending;
    }

    public void setPending(ArrayList<Pending> pending) {
        this.pending = pending;
    }

    public ArrayList<Processing> getProcessing() {
        return processing;
    }

    public void setProcessing(ArrayList<Processing> processing) {
        this.processing = processing;
    }

    public static class Completed {
        @Expose
        @SerializedName("order_approval_status")
        public String orderApprovalStatus;
        @Expose
        @SerializedName("paypal_ipn_customer_notified")
        public String paypalIpnCustomerNotified;
        @Expose
        @SerializedName("coupon_rule_name")
        public String couponRuleName;
        @Expose
        @SerializedName("base_shipping_incl_tax")
        public String baseShippingInclTax;
        @Expose
        @SerializedName("shipping_incl_tax")
        public String shippingInclTax;
        @Expose
        @SerializedName("base_discount_tax_compensation_invoiced")
        public String baseDiscountTaxCompensationInvoiced;
        @Expose
        @SerializedName("discount_tax_compensation_invoiced")
        public String discountTaxCompensationInvoiced;
        @Expose
        @SerializedName("base_shipping_discount_tax_compensation_amnt")
        public String baseShippingDiscountTaxCompensationAmnt;
        @Expose
        @SerializedName("shipping_discount_tax_compensation_amount")
        public String shippingDiscountTaxCompensationAmount;
        @Expose
        @SerializedName("base_discount_tax_compensation_amount")
        public String baseDiscountTaxCompensationAmount;
        @Expose
        @SerializedName("discount_tax_compensation_amount")
        public String discountTaxCompensationAmount;
        @Expose
        @SerializedName("total_item_count")
        public String totalItemCount;
        @Expose
        @SerializedName("updated_at")
        public String updatedAt;
        @Expose
        @SerializedName("created_at")
        public String createdAt;
        @Expose
        @SerializedName("store_name")
        public String storeName;
        @Expose
        @SerializedName("store_currency_code")
        public String storeCurrencyCode;
        @Expose
        @SerializedName("shipping_method")
        public String shippingMethod;
        @Expose
        @SerializedName("remote_ip")
        public String remoteIp;
        @Expose
        @SerializedName("order_currency_code")
        public String orderCurrencyCode;
        @Expose
        @SerializedName("global_currency_code")
        public String globalCurrencyCode;
        @Expose
        @SerializedName("discount_description")
        public String discountDescription;
        @Expose
        @SerializedName("customer_lastname")
        public String customerLastname;
        @Expose
        @SerializedName("customer_firstname")
        public String customerFirstname;
        @Expose
        @SerializedName("customer_email")
        public String customerEmail;
        @Expose
        @SerializedName("base_currency_code")
        public String baseCurrencyCode;
        @Expose
        @SerializedName("applied_rule_ids")
        public String appliedRuleIds;
        @Expose
        @SerializedName("increment_id")
        public String incrementId;
        @Expose
        @SerializedName("weight")
        public String weight;
        @Expose
        @SerializedName("total_due")
        public String totalDue;
        @Expose
        @SerializedName("subtotal_incl_tax")
        public String subtotalInclTax;
        @Expose
        @SerializedName("shipping_discount_amount")
        public String shippingDiscountAmount;
        @Expose
        @SerializedName("base_total_due")
        public String baseTotalDue;
        @Expose
        @SerializedName("base_subtotal_incl_tax")
        public String baseSubtotalInclTax;
        @Expose
        @SerializedName("base_shipping_discount_amount")
        public String baseShippingDiscountAmount;
        @Expose
        @SerializedName("shipping_address_id")
        public String shippingAddressId;
        @Expose
        @SerializedName("quote_id")
        public String quoteId;
        @Expose
        @SerializedName("send_email")
        public String sendEmail;
        @Expose
        @SerializedName("email_sent")
        public String emailSent;
        @Expose
        @SerializedName("customer_group_id")
        public String customerGroupId;
        @Expose
        @SerializedName("billing_address_id")
        public String billingAddressId;
        @Expose
        @SerializedName("customer_note_notify")
        public String customerNoteNotify;
        @Expose
        @SerializedName("customer_is_guest")
        public String customerIsGuest;
        @Expose
        @SerializedName("total_qty_ordered")
        public String totalQtyOrdered;
        @Expose
        @SerializedName("total_paid")
        public String totalPaid;
        @Expose
        @SerializedName("total_invoiced")
        public String totalInvoiced;
        @Expose
        @SerializedName("tax_invoiced")
        public String taxInvoiced;
        @Expose
        @SerializedName("tax_amount")
        public String taxAmount;
        @Expose
        @SerializedName("subtotal_invoiced")
        public String subtotalInvoiced;
        @Expose
        @SerializedName("subtotal")
        public String subtotal;
        @Expose
        @SerializedName("store_to_order_rate")
        public String storeToOrderRate;
        @Expose
        @SerializedName("store_to_base_rate")
        public String storeToBaseRate;
        @Expose
        @SerializedName("shipping_tax_amount")
        public String shippingTaxAmount;
        @Expose
        @SerializedName("shipping_invoiced")
        public String shippingInvoiced;
        @Expose
        @SerializedName("shipping_amount")
        public String shippingAmount;
        @Expose
        @SerializedName("grand_total")
        public String grandTotal;
        @Expose
        @SerializedName("discount_invoiced")
        public String discountInvoiced;
        @Expose
        @SerializedName("discount_amount")
        public String discountAmount;
        @Expose
        @SerializedName("base_total_paid")
        public String baseTotalPaid;
        @Expose
        @SerializedName("base_total_invoiced_cost")
        public String baseTotalInvoicedCost;
        @Expose
        @SerializedName("base_total_invoiced")
        public String baseTotalInvoiced;
        @Expose
        @SerializedName("base_to_order_rate")
        public String baseToOrderRate;
        @Expose
        @SerializedName("base_to_global_rate")
        public String baseToGlobalRate;
        @Expose
        @SerializedName("base_tax_invoiced")
        public String baseTaxInvoiced;
        @Expose
        @SerializedName("base_tax_amount")
        public String baseTaxAmount;
        @Expose
        @SerializedName("base_subtotal_invoiced")
        public String baseSubtotalInvoiced;
        @Expose
        @SerializedName("base_subtotal")
        public String baseSubtotal;
        @Expose
        @SerializedName("base_shipping_tax_amount")
        public String baseShippingTaxAmount;
        @Expose
        @SerializedName("base_shipping_invoiced")
        public String baseShippingInvoiced;
        @Expose
        @SerializedName("base_shipping_amount")
        public String baseShippingAmount;
        @Expose
        @SerializedName("base_grand_total")
        public String baseGrandTotal;
        @Expose
        @SerializedName("base_discount_invoiced")
        public String baseDiscountInvoiced;
        @Expose
        @SerializedName("base_discount_amount")
        public String baseDiscountAmount;
        @Expose
        @SerializedName("customer_id")
        public String customerId;
        @Expose
        @SerializedName("store_id")
        public String storeId;
        @Expose
        @SerializedName("is_virtual")
        public String isVirtual;
        @Expose
        @SerializedName("shipping_description")
        public String shippingDescription;
        @Expose
        @SerializedName("protect_code")
        public String protectCode;
        @Expose
        @SerializedName("coupon_code")
        public String couponCode;
        @Expose
        @SerializedName("status")
        public String status;
        @Expose
        @SerializedName("state")
        public String state;
        @Expose
        @SerializedName("entity_id")
        public String entityId;

        public Completed(String customerLastname, String customerFirstname, String status, String entityId, String grand_total) {
            this.customerLastname = customerLastname;
            this.customerFirstname = customerFirstname;
            this.status = status;
            this.entityId = entityId;
            this.grandTotal = grand_total;
        }

        public String getOrderApprovalStatus() {
            return orderApprovalStatus;
        }

        public void setOrderApprovalStatus(String orderApprovalStatus) {
            this.orderApprovalStatus = orderApprovalStatus;
        }

        public String getPaypalIpnCustomerNotified() {
            return paypalIpnCustomerNotified;
        }

        public void setPaypalIpnCustomerNotified(String paypalIpnCustomerNotified) {
            this.paypalIpnCustomerNotified = paypalIpnCustomerNotified;
        }

        public String getCouponRuleName() {
            return couponRuleName;
        }

        public void setCouponRuleName(String couponRuleName) {
            this.couponRuleName = couponRuleName;
        }

        public String getBaseShippingInclTax() {
            return baseShippingInclTax;
        }

        public void setBaseShippingInclTax(String baseShippingInclTax) {
            this.baseShippingInclTax = baseShippingInclTax;
        }

        public String getShippingInclTax() {
            return shippingInclTax;
        }

        public void setShippingInclTax(String shippingInclTax) {
            this.shippingInclTax = shippingInclTax;
        }

        public String getBaseDiscountTaxCompensationInvoiced() {
            return baseDiscountTaxCompensationInvoiced;
        }

        public void setBaseDiscountTaxCompensationInvoiced(String baseDiscountTaxCompensationInvoiced) {
            this.baseDiscountTaxCompensationInvoiced = baseDiscountTaxCompensationInvoiced;
        }

        public String getDiscountTaxCompensationInvoiced() {
            return discountTaxCompensationInvoiced;
        }

        public void setDiscountTaxCompensationInvoiced(String discountTaxCompensationInvoiced) {
            this.discountTaxCompensationInvoiced = discountTaxCompensationInvoiced;
        }

        public String getBaseShippingDiscountTaxCompensationAmnt() {
            return baseShippingDiscountTaxCompensationAmnt;
        }

        public void setBaseShippingDiscountTaxCompensationAmnt(String baseShippingDiscountTaxCompensationAmnt) {
            this.baseShippingDiscountTaxCompensationAmnt = baseShippingDiscountTaxCompensationAmnt;
        }

        public String getShippingDiscountTaxCompensationAmount() {
            return shippingDiscountTaxCompensationAmount;
        }

        public void setShippingDiscountTaxCompensationAmount(String shippingDiscountTaxCompensationAmount) {
            this.shippingDiscountTaxCompensationAmount = shippingDiscountTaxCompensationAmount;
        }

        public String getBaseDiscountTaxCompensationAmount() {
            return baseDiscountTaxCompensationAmount;
        }

        public void setBaseDiscountTaxCompensationAmount(String baseDiscountTaxCompensationAmount) {
            this.baseDiscountTaxCompensationAmount = baseDiscountTaxCompensationAmount;
        }

        public String getDiscountTaxCompensationAmount() {
            return discountTaxCompensationAmount;
        }

        public void setDiscountTaxCompensationAmount(String discountTaxCompensationAmount) {
            this.discountTaxCompensationAmount = discountTaxCompensationAmount;
        }

        public String getTotalItemCount() {
            return totalItemCount;
        }

        public void setTotalItemCount(String totalItemCount) {
            this.totalItemCount = totalItemCount;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getStoreName() {
            return storeName;
        }

        public void setStoreName(String storeName) {
            this.storeName = storeName;
        }

        public String getStoreCurrencyCode() {
            return storeCurrencyCode;
        }

        public void setStoreCurrencyCode(String storeCurrencyCode) {
            this.storeCurrencyCode = storeCurrencyCode;
        }

        public String getShippingMethod() {
            return shippingMethod;
        }

        public void setShippingMethod(String shippingMethod) {
            this.shippingMethod = shippingMethod;
        }

        public String getRemoteIp() {
            return remoteIp;
        }

        public void setRemoteIp(String remoteIp) {
            this.remoteIp = remoteIp;
        }

        public String getOrderCurrencyCode() {
            return orderCurrencyCode;
        }

        public void setOrderCurrencyCode(String orderCurrencyCode) {
            this.orderCurrencyCode = orderCurrencyCode;
        }

        public String getGlobalCurrencyCode() {
            return globalCurrencyCode;
        }

        public void setGlobalCurrencyCode(String globalCurrencyCode) {
            this.globalCurrencyCode = globalCurrencyCode;
        }

        public String getDiscountDescription() {
            return discountDescription;
        }

        public void setDiscountDescription(String discountDescription) {
            this.discountDescription = discountDescription;
        }

        public String getCustomerLastname() {
            return customerLastname;
        }

        public void setCustomerLastname(String customerLastname) {
            this.customerLastname = customerLastname;
        }

        public String getCustomerFirstname() {
            return customerFirstname;
        }

        public void setCustomerFirstname(String customerFirstname) {
            this.customerFirstname = customerFirstname;
        }

        public String getCustomerEmail() {
            return customerEmail;
        }

        public void setCustomerEmail(String customerEmail) {
            this.customerEmail = customerEmail;
        }

        public String getBaseCurrencyCode() {
            return baseCurrencyCode;
        }

        public void setBaseCurrencyCode(String baseCurrencyCode) {
            this.baseCurrencyCode = baseCurrencyCode;
        }

        public String getAppliedRuleIds() {
            return appliedRuleIds;
        }

        public void setAppliedRuleIds(String appliedRuleIds) {
            this.appliedRuleIds = appliedRuleIds;
        }

        public String getIncrementId() {
            return incrementId;
        }

        public void setIncrementId(String incrementId) {
            this.incrementId = incrementId;
        }

        public String getWeight() {
            return weight;
        }

        public void setWeight(String weight) {
            this.weight = weight;
        }

        public String getTotalDue() {
            return totalDue;
        }

        public void setTotalDue(String totalDue) {
            this.totalDue = totalDue;
        }

        public String getSubtotalInclTax() {
            return subtotalInclTax;
        }

        public void setSubtotalInclTax(String subtotalInclTax) {
            this.subtotalInclTax = subtotalInclTax;
        }

        public String getShippingDiscountAmount() {
            return shippingDiscountAmount;
        }

        public void setShippingDiscountAmount(String shippingDiscountAmount) {
            this.shippingDiscountAmount = shippingDiscountAmount;
        }

        public String getBaseTotalDue() {
            return baseTotalDue;
        }

        public void setBaseTotalDue(String baseTotalDue) {
            this.baseTotalDue = baseTotalDue;
        }

        public String getBaseSubtotalInclTax() {
            return baseSubtotalInclTax;
        }

        public void setBaseSubtotalInclTax(String baseSubtotalInclTax) {
            this.baseSubtotalInclTax = baseSubtotalInclTax;
        }

        public String getBaseShippingDiscountAmount() {
            return baseShippingDiscountAmount;
        }

        public void setBaseShippingDiscountAmount(String baseShippingDiscountAmount) {
            this.baseShippingDiscountAmount = baseShippingDiscountAmount;
        }

        public String getShippingAddressId() {
            return shippingAddressId;
        }

        public void setShippingAddressId(String shippingAddressId) {
            this.shippingAddressId = shippingAddressId;
        }

        public String getQuoteId() {
            return quoteId;
        }

        public void setQuoteId(String quoteId) {
            this.quoteId = quoteId;
        }

        public String getSendEmail() {
            return sendEmail;
        }

        public void setSendEmail(String sendEmail) {
            this.sendEmail = sendEmail;
        }

        public String getEmailSent() {
            return emailSent;
        }

        public void setEmailSent(String emailSent) {
            this.emailSent = emailSent;
        }

        public String getCustomerGroupId() {
            return customerGroupId;
        }

        public void setCustomerGroupId(String customerGroupId) {
            this.customerGroupId = customerGroupId;
        }

        public String getBillingAddressId() {
            return billingAddressId;
        }

        public void setBillingAddressId(String billingAddressId) {
            this.billingAddressId = billingAddressId;
        }

        public String getCustomerNoteNotify() {
            return customerNoteNotify;
        }

        public void setCustomerNoteNotify(String customerNoteNotify) {
            this.customerNoteNotify = customerNoteNotify;
        }

        public String getCustomerIsGuest() {
            return customerIsGuest;
        }

        public void setCustomerIsGuest(String customerIsGuest) {
            this.customerIsGuest = customerIsGuest;
        }

        public String getTotalQtyOrdered() {
            return totalQtyOrdered;
        }

        public void setTotalQtyOrdered(String totalQtyOrdered) {
            this.totalQtyOrdered = totalQtyOrdered;
        }

        public String getTotalPaid() {
            return totalPaid;
        }

        public void setTotalPaid(String totalPaid) {
            this.totalPaid = totalPaid;
        }

        public String getTotalInvoiced() {
            return totalInvoiced;
        }

        public void setTotalInvoiced(String totalInvoiced) {
            this.totalInvoiced = totalInvoiced;
        }

        public String getTaxInvoiced() {
            return taxInvoiced;
        }

        public void setTaxInvoiced(String taxInvoiced) {
            this.taxInvoiced = taxInvoiced;
        }

        public String getTaxAmount() {
            return taxAmount;
        }

        public void setTaxAmount(String taxAmount) {
            this.taxAmount = taxAmount;
        }

        public String getSubtotalInvoiced() {
            return subtotalInvoiced;
        }

        public void setSubtotalInvoiced(String subtotalInvoiced) {
            this.subtotalInvoiced = subtotalInvoiced;
        }

        public String getSubtotal() {
            return subtotal;
        }

        public void setSubtotal(String subtotal) {
            this.subtotal = subtotal;
        }

        public String getStoreToOrderRate() {
            return storeToOrderRate;
        }

        public void setStoreToOrderRate(String storeToOrderRate) {
            this.storeToOrderRate = storeToOrderRate;
        }

        public String getStoreToBaseRate() {
            return storeToBaseRate;
        }

        public void setStoreToBaseRate(String storeToBaseRate) {
            this.storeToBaseRate = storeToBaseRate;
        }

        public String getShippingTaxAmount() {
            return shippingTaxAmount;
        }

        public void setShippingTaxAmount(String shippingTaxAmount) {
            this.shippingTaxAmount = shippingTaxAmount;
        }

        public String getShippingInvoiced() {
            return shippingInvoiced;
        }

        public void setShippingInvoiced(String shippingInvoiced) {
            this.shippingInvoiced = shippingInvoiced;
        }

        public String getShippingAmount() {
            return shippingAmount;
        }

        public void setShippingAmount(String shippingAmount) {
            this.shippingAmount = shippingAmount;
        }

        public String getGrandTotal() {
            return grandTotal;
        }

        public void setGrandTotal(String grandTotal) {
            this.grandTotal = grandTotal;
        }

        public String getDiscountInvoiced() {
            return discountInvoiced;
        }

        public void setDiscountInvoiced(String discountInvoiced) {
            this.discountInvoiced = discountInvoiced;
        }

        public String getDiscountAmount() {
            return discountAmount;
        }

        public void setDiscountAmount(String discountAmount) {
            this.discountAmount = discountAmount;
        }

        public String getBaseTotalPaid() {
            return baseTotalPaid;
        }

        public void setBaseTotalPaid(String baseTotalPaid) {
            this.baseTotalPaid = baseTotalPaid;
        }

        public String getBaseTotalInvoicedCost() {
            return baseTotalInvoicedCost;
        }

        public void setBaseTotalInvoicedCost(String baseTotalInvoicedCost) {
            this.baseTotalInvoicedCost = baseTotalInvoicedCost;
        }

        public String getBaseTotalInvoiced() {
            return baseTotalInvoiced;
        }

        public void setBaseTotalInvoiced(String baseTotalInvoiced) {
            this.baseTotalInvoiced = baseTotalInvoiced;
        }

        public String getBaseToOrderRate() {
            return baseToOrderRate;
        }

        public void setBaseToOrderRate(String baseToOrderRate) {
            this.baseToOrderRate = baseToOrderRate;
        }

        public String getBaseToGlobalRate() {
            return baseToGlobalRate;
        }

        public void setBaseToGlobalRate(String baseToGlobalRate) {
            this.baseToGlobalRate = baseToGlobalRate;
        }

        public String getBaseTaxInvoiced() {
            return baseTaxInvoiced;
        }

        public void setBaseTaxInvoiced(String baseTaxInvoiced) {
            this.baseTaxInvoiced = baseTaxInvoiced;
        }

        public String getBaseTaxAmount() {
            return baseTaxAmount;
        }

        public void setBaseTaxAmount(String baseTaxAmount) {
            this.baseTaxAmount = baseTaxAmount;
        }

        public String getBaseSubtotalInvoiced() {
            return baseSubtotalInvoiced;
        }

        public void setBaseSubtotalInvoiced(String baseSubtotalInvoiced) {
            this.baseSubtotalInvoiced = baseSubtotalInvoiced;
        }

        public String getBaseSubtotal() {
            return baseSubtotal;
        }

        public void setBaseSubtotal(String baseSubtotal) {
            this.baseSubtotal = baseSubtotal;
        }

        public String getBaseShippingTaxAmount() {
            return baseShippingTaxAmount;
        }

        public void setBaseShippingTaxAmount(String baseShippingTaxAmount) {
            this.baseShippingTaxAmount = baseShippingTaxAmount;
        }

        public String getBaseShippingInvoiced() {
            return baseShippingInvoiced;
        }

        public void setBaseShippingInvoiced(String baseShippingInvoiced) {
            this.baseShippingInvoiced = baseShippingInvoiced;
        }

        public String getBaseShippingAmount() {
            return baseShippingAmount;
        }

        public void setBaseShippingAmount(String baseShippingAmount) {
            this.baseShippingAmount = baseShippingAmount;
        }

        public String getBaseGrandTotal() {
            return baseGrandTotal;
        }

        public void setBaseGrandTotal(String baseGrandTotal) {
            this.baseGrandTotal = baseGrandTotal;
        }

        public String getBaseDiscountInvoiced() {
            return baseDiscountInvoiced;
        }

        public void setBaseDiscountInvoiced(String baseDiscountInvoiced) {
            this.baseDiscountInvoiced = baseDiscountInvoiced;
        }

        public String getBaseDiscountAmount() {
            return baseDiscountAmount;
        }

        public void setBaseDiscountAmount(String baseDiscountAmount) {
            this.baseDiscountAmount = baseDiscountAmount;
        }

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getStoreId() {
            return storeId;
        }

        public void setStoreId(String storeId) {
            this.storeId = storeId;
        }

        public String getIsVirtual() {
            return isVirtual;
        }

        public void setIsVirtual(String isVirtual) {
            this.isVirtual = isVirtual;
        }

        public String getShippingDescription() {
            return shippingDescription;
        }

        public void setShippingDescription(String shippingDescription) {
            this.shippingDescription = shippingDescription;
        }

        public String getProtectCode() {
            return protectCode;
        }

        public void setProtectCode(String protectCode) {
            this.protectCode = protectCode;
        }

        public String getCouponCode() {
            return couponCode;
        }

        public void setCouponCode(String couponCode) {
            this.couponCode = couponCode;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getEntityId() {
            return entityId;
        }

        public void setEntityId(String entityId) {
            this.entityId = entityId;
        }
    }

    public static class Processing {
        @Expose
        @SerializedName("order_approval_status")
        public String orderApprovalStatus;
        @Expose
        @SerializedName("paypal_ipn_customer_notified")
        public String paypalIpnCustomerNotified;
        @Expose
        @SerializedName("coupon_rule_name")
        public String couponRuleName;
        @Expose
        @SerializedName("base_shipping_incl_tax")
        public String baseShippingInclTax;
        @Expose
        @SerializedName("shipping_incl_tax")
        public String shippingInclTax;
        @Expose
        @SerializedName("base_discount_tax_compensation_invoiced")
        public String baseDiscountTaxCompensationInvoiced;
        @Expose
        @SerializedName("discount_tax_compensation_invoiced")
        public String discountTaxCompensationInvoiced;
        @Expose
        @SerializedName("base_shipping_discount_tax_compensation_amnt")
        public String baseShippingDiscountTaxCompensationAmnt;
        @Expose
        @SerializedName("shipping_discount_tax_compensation_amount")
        public String shippingDiscountTaxCompensationAmount;
        @Expose
        @SerializedName("base_discount_tax_compensation_amount")
        public String baseDiscountTaxCompensationAmount;
        @Expose
        @SerializedName("discount_tax_compensation_amount")
        public String discountTaxCompensationAmount;
        @Expose
        @SerializedName("total_item_count")
        public String totalItemCount;
        @Expose
        @SerializedName("updated_at")
        public String updatedAt;
        @Expose
        @SerializedName("created_at")
        public String createdAt;
        @Expose
        @SerializedName("store_name")
        public String storeName;
        @Expose
        @SerializedName("store_currency_code")
        public String storeCurrencyCode;
        @Expose
        @SerializedName("shipping_method")
        public String shippingMethod;
        @Expose
        @SerializedName("remote_ip")
        public String remoteIp;
        @Expose
        @SerializedName("order_currency_code")
        public String orderCurrencyCode;
        @Expose
        @SerializedName("global_currency_code")
        public String globalCurrencyCode;
        @Expose
        @SerializedName("discount_description")
        public String discountDescription;
        @Expose
        @SerializedName("customer_lastname")
        public String customerLastname;
        @Expose
        @SerializedName("customer_firstname")
        public String customerFirstname;
        @Expose
        @SerializedName("customer_email")
        public String customerEmail;
        @Expose
        @SerializedName("base_currency_code")
        public String baseCurrencyCode;
        @Expose
        @SerializedName("applied_rule_ids")
        public String appliedRuleIds;
        @Expose
        @SerializedName("increment_id")
        public String incrementId;
        @Expose
        @SerializedName("weight")
        public String weight;
        @Expose
        @SerializedName("total_due")
        public String totalDue;
        @Expose
        @SerializedName("subtotal_incl_tax")
        public String subtotalInclTax;
        @Expose
        @SerializedName("shipping_discount_amount")
        public String shippingDiscountAmount;
        @Expose
        @SerializedName("base_total_due")
        public String baseTotalDue;
        @Expose
        @SerializedName("base_subtotal_incl_tax")
        public String baseSubtotalInclTax;
        @Expose
        @SerializedName("base_shipping_discount_amount")
        public String baseShippingDiscountAmount;
        @Expose
        @SerializedName("shipping_address_id")
        public String shippingAddressId;
        @Expose
        @SerializedName("quote_id")
        public String quoteId;
        @Expose
        @SerializedName("send_email")
        public String sendEmail;
        @Expose
        @SerializedName("email_sent")
        public String emailSent;
        @Expose
        @SerializedName("customer_group_id")
        public String customerGroupId;
        @Expose
        @SerializedName("billing_address_id")
        public String billingAddressId;
        @Expose
        @SerializedName("customer_note_notify")
        public String customerNoteNotify;
        @Expose
        @SerializedName("customer_is_guest")
        public String customerIsGuest;
        @Expose
        @SerializedName("total_qty_ordered")
        public String totalQtyOrdered;
        @Expose
        @SerializedName("total_paid")
        public String totalPaid;
        @Expose
        @SerializedName("total_invoiced")
        public String totalInvoiced;
        @Expose
        @SerializedName("tax_invoiced")
        public String taxInvoiced;
        @Expose
        @SerializedName("tax_amount")
        public String taxAmount;
        @Expose
        @SerializedName("subtotal_invoiced")
        public String subtotalInvoiced;
        @Expose
        @SerializedName("subtotal")
        public String subtotal;
        @Expose
        @SerializedName("store_to_order_rate")
        public String storeToOrderRate;
        @Expose
        @SerializedName("store_to_base_rate")
        public String storeToBaseRate;
        @Expose
        @SerializedName("shipping_tax_amount")
        public String shippingTaxAmount;
        @Expose
        @SerializedName("shipping_invoiced")
        public String shippingInvoiced;
        @Expose
        @SerializedName("shipping_amount")
        public String shippingAmount;
        @Expose
        @SerializedName("grand_total")
        public String grandTotal;
        @Expose
        @SerializedName("discount_invoiced")
        public String discountInvoiced;
        @Expose
        @SerializedName("discount_amount")
        public String discountAmount;
        @Expose
        @SerializedName("base_total_paid")
        public String baseTotalPaid;
        @Expose
        @SerializedName("base_total_invoiced_cost")
        public String baseTotalInvoicedCost;
        @Expose
        @SerializedName("base_total_invoiced")
        public String baseTotalInvoiced;
        @Expose
        @SerializedName("base_to_order_rate")
        public String baseToOrderRate;
        @Expose
        @SerializedName("base_to_global_rate")
        public String baseToGlobalRate;
        @Expose
        @SerializedName("base_tax_invoiced")
        public String baseTaxInvoiced;
        @Expose
        @SerializedName("base_tax_amount")
        public String baseTaxAmount;
        @Expose
        @SerializedName("base_subtotal_invoiced")
        public String baseSubtotalInvoiced;
        @Expose
        @SerializedName("base_subtotal")
        public String baseSubtotal;
        @Expose
        @SerializedName("base_shipping_tax_amount")
        public String baseShippingTaxAmount;
        @Expose
        @SerializedName("base_shipping_invoiced")
        public String baseShippingInvoiced;
        @Expose
        @SerializedName("base_shipping_amount")
        public String baseShippingAmount;
        @Expose
        @SerializedName("base_grand_total")
        public String baseGrandTotal;
        @Expose
        @SerializedName("base_discount_invoiced")
        public String baseDiscountInvoiced;
        @Expose
        @SerializedName("base_discount_amount")
        public String baseDiscountAmount;
        @Expose
        @SerializedName("customer_id")
        public String customerId;
        @Expose
        @SerializedName("store_id")
        public String storeId;
        @Expose
        @SerializedName("is_virtual")
        public String isVirtual;
        @Expose
        @SerializedName("shipping_description")
        public String shippingDescription;
        @Expose
        @SerializedName("protect_code")
        public String protectCode;
        @Expose
        @SerializedName("coupon_code")
        public String couponCode;
        @Expose
        @SerializedName("status")
        public String status;
        @Expose
        @SerializedName("state")
        public String state;
        @Expose
        @SerializedName("entity_id")
        public String entityId;

        public Processing(String customerLastname, String customerFirstname, String status, String entityId,String grand_total) {
            this.customerLastname = customerLastname;
            this.customerFirstname = customerFirstname;
            this.status = status;
            this.entityId = entityId;
            this.grandTotal = grand_total;
        }

        public String getOrderApprovalStatus() {
            return orderApprovalStatus;
        }

        public void setOrderApprovalStatus(String orderApprovalStatus) {
            this.orderApprovalStatus = orderApprovalStatus;
        }

        public String getPaypalIpnCustomerNotified() {
            return paypalIpnCustomerNotified;
        }

        public void setPaypalIpnCustomerNotified(String paypalIpnCustomerNotified) {
            this.paypalIpnCustomerNotified = paypalIpnCustomerNotified;
        }

        public String getCouponRuleName() {
            return couponRuleName;
        }

        public void setCouponRuleName(String couponRuleName) {
            this.couponRuleName = couponRuleName;
        }

        public String getBaseShippingInclTax() {
            return baseShippingInclTax;
        }

        public void setBaseShippingInclTax(String baseShippingInclTax) {
            this.baseShippingInclTax = baseShippingInclTax;
        }

        public String getShippingInclTax() {
            return shippingInclTax;
        }

        public void setShippingInclTax(String shippingInclTax) {
            this.shippingInclTax = shippingInclTax;
        }

        public String getBaseDiscountTaxCompensationInvoiced() {
            return baseDiscountTaxCompensationInvoiced;
        }

        public void setBaseDiscountTaxCompensationInvoiced(String baseDiscountTaxCompensationInvoiced) {
            this.baseDiscountTaxCompensationInvoiced = baseDiscountTaxCompensationInvoiced;
        }

        public String getDiscountTaxCompensationInvoiced() {
            return discountTaxCompensationInvoiced;
        }

        public void setDiscountTaxCompensationInvoiced(String discountTaxCompensationInvoiced) {
            this.discountTaxCompensationInvoiced = discountTaxCompensationInvoiced;
        }

        public String getBaseShippingDiscountTaxCompensationAmnt() {
            return baseShippingDiscountTaxCompensationAmnt;
        }

        public void setBaseShippingDiscountTaxCompensationAmnt(String baseShippingDiscountTaxCompensationAmnt) {
            this.baseShippingDiscountTaxCompensationAmnt = baseShippingDiscountTaxCompensationAmnt;
        }

        public String getShippingDiscountTaxCompensationAmount() {
            return shippingDiscountTaxCompensationAmount;
        }

        public void setShippingDiscountTaxCompensationAmount(String shippingDiscountTaxCompensationAmount) {
            this.shippingDiscountTaxCompensationAmount = shippingDiscountTaxCompensationAmount;
        }

        public String getBaseDiscountTaxCompensationAmount() {
            return baseDiscountTaxCompensationAmount;
        }

        public void setBaseDiscountTaxCompensationAmount(String baseDiscountTaxCompensationAmount) {
            this.baseDiscountTaxCompensationAmount = baseDiscountTaxCompensationAmount;
        }

        public String getDiscountTaxCompensationAmount() {
            return discountTaxCompensationAmount;
        }

        public void setDiscountTaxCompensationAmount(String discountTaxCompensationAmount) {
            this.discountTaxCompensationAmount = discountTaxCompensationAmount;
        }

        public String getTotalItemCount() {
            return totalItemCount;
        }

        public void setTotalItemCount(String totalItemCount) {
            this.totalItemCount = totalItemCount;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getStoreName() {
            return storeName;
        }

        public void setStoreName(String storeName) {
            this.storeName = storeName;
        }

        public String getStoreCurrencyCode() {
            return storeCurrencyCode;
        }

        public void setStoreCurrencyCode(String storeCurrencyCode) {
            this.storeCurrencyCode = storeCurrencyCode;
        }

        public String getShippingMethod() {
            return shippingMethod;
        }

        public void setShippingMethod(String shippingMethod) {
            this.shippingMethod = shippingMethod;
        }

        public String getRemoteIp() {
            return remoteIp;
        }

        public void setRemoteIp(String remoteIp) {
            this.remoteIp = remoteIp;
        }

        public String getOrderCurrencyCode() {
            return orderCurrencyCode;
        }

        public void setOrderCurrencyCode(String orderCurrencyCode) {
            this.orderCurrencyCode = orderCurrencyCode;
        }

        public String getGlobalCurrencyCode() {
            return globalCurrencyCode;
        }

        public void setGlobalCurrencyCode(String globalCurrencyCode) {
            this.globalCurrencyCode = globalCurrencyCode;
        }

        public String getDiscountDescription() {
            return discountDescription;
        }

        public void setDiscountDescription(String discountDescription) {
            this.discountDescription = discountDescription;
        }

        public String getCustomerLastname() {
            return customerLastname;
        }

        public void setCustomerLastname(String customerLastname) {
            this.customerLastname = customerLastname;
        }

        public String getCustomerFirstname() {
            return customerFirstname;
        }

        public void setCustomerFirstname(String customerFirstname) {
            this.customerFirstname = customerFirstname;
        }

        public String getCustomerEmail() {
            return customerEmail;
        }

        public void setCustomerEmail(String customerEmail) {
            this.customerEmail = customerEmail;
        }

        public String getBaseCurrencyCode() {
            return baseCurrencyCode;
        }

        public void setBaseCurrencyCode(String baseCurrencyCode) {
            this.baseCurrencyCode = baseCurrencyCode;
        }

        public String getAppliedRuleIds() {
            return appliedRuleIds;
        }

        public void setAppliedRuleIds(String appliedRuleIds) {
            this.appliedRuleIds = appliedRuleIds;
        }

        public String getIncrementId() {
            return incrementId;
        }

        public void setIncrementId(String incrementId) {
            this.incrementId = incrementId;
        }

        public String getWeight() {
            return weight;
        }

        public void setWeight(String weight) {
            this.weight = weight;
        }

        public String getTotalDue() {
            return totalDue;
        }

        public void setTotalDue(String totalDue) {
            this.totalDue = totalDue;
        }

        public String getSubtotalInclTax() {
            return subtotalInclTax;
        }

        public void setSubtotalInclTax(String subtotalInclTax) {
            this.subtotalInclTax = subtotalInclTax;
        }

        public String getShippingDiscountAmount() {
            return shippingDiscountAmount;
        }

        public void setShippingDiscountAmount(String shippingDiscountAmount) {
            this.shippingDiscountAmount = shippingDiscountAmount;
        }

        public String getBaseTotalDue() {
            return baseTotalDue;
        }

        public void setBaseTotalDue(String baseTotalDue) {
            this.baseTotalDue = baseTotalDue;
        }

        public String getBaseSubtotalInclTax() {
            return baseSubtotalInclTax;
        }

        public void setBaseSubtotalInclTax(String baseSubtotalInclTax) {
            this.baseSubtotalInclTax = baseSubtotalInclTax;
        }

        public String getBaseShippingDiscountAmount() {
            return baseShippingDiscountAmount;
        }

        public void setBaseShippingDiscountAmount(String baseShippingDiscountAmount) {
            this.baseShippingDiscountAmount = baseShippingDiscountAmount;
        }

        public String getShippingAddressId() {
            return shippingAddressId;
        }

        public void setShippingAddressId(String shippingAddressId) {
            this.shippingAddressId = shippingAddressId;
        }

        public String getQuoteId() {
            return quoteId;
        }

        public void setQuoteId(String quoteId) {
            this.quoteId = quoteId;
        }

        public String getSendEmail() {
            return sendEmail;
        }

        public void setSendEmail(String sendEmail) {
            this.sendEmail = sendEmail;
        }

        public String getEmailSent() {
            return emailSent;
        }

        public void setEmailSent(String emailSent) {
            this.emailSent = emailSent;
        }

        public String getCustomerGroupId() {
            return customerGroupId;
        }

        public void setCustomerGroupId(String customerGroupId) {
            this.customerGroupId = customerGroupId;
        }

        public String getBillingAddressId() {
            return billingAddressId;
        }

        public void setBillingAddressId(String billingAddressId) {
            this.billingAddressId = billingAddressId;
        }

        public String getCustomerNoteNotify() {
            return customerNoteNotify;
        }

        public void setCustomerNoteNotify(String customerNoteNotify) {
            this.customerNoteNotify = customerNoteNotify;
        }

        public String getCustomerIsGuest() {
            return customerIsGuest;
        }

        public void setCustomerIsGuest(String customerIsGuest) {
            this.customerIsGuest = customerIsGuest;
        }

        public String getTotalQtyOrdered() {
            return totalQtyOrdered;
        }

        public void setTotalQtyOrdered(String totalQtyOrdered) {
            this.totalQtyOrdered = totalQtyOrdered;
        }

        public String getTotalPaid() {
            return totalPaid;
        }

        public void setTotalPaid(String totalPaid) {
            this.totalPaid = totalPaid;
        }

        public String getTotalInvoiced() {
            return totalInvoiced;
        }

        public void setTotalInvoiced(String totalInvoiced) {
            this.totalInvoiced = totalInvoiced;
        }

        public String getTaxInvoiced() {
            return taxInvoiced;
        }

        public void setTaxInvoiced(String taxInvoiced) {
            this.taxInvoiced = taxInvoiced;
        }

        public String getTaxAmount() {
            return taxAmount;
        }

        public void setTaxAmount(String taxAmount) {
            this.taxAmount = taxAmount;
        }

        public String getSubtotalInvoiced() {
            return subtotalInvoiced;
        }

        public void setSubtotalInvoiced(String subtotalInvoiced) {
            this.subtotalInvoiced = subtotalInvoiced;
        }

        public String getSubtotal() {
            return subtotal;
        }

        public void setSubtotal(String subtotal) {
            this.subtotal = subtotal;
        }

        public String getStoreToOrderRate() {
            return storeToOrderRate;
        }

        public void setStoreToOrderRate(String storeToOrderRate) {
            this.storeToOrderRate = storeToOrderRate;
        }

        public String getStoreToBaseRate() {
            return storeToBaseRate;
        }

        public void setStoreToBaseRate(String storeToBaseRate) {
            this.storeToBaseRate = storeToBaseRate;
        }

        public String getShippingTaxAmount() {
            return shippingTaxAmount;
        }

        public void setShippingTaxAmount(String shippingTaxAmount) {
            this.shippingTaxAmount = shippingTaxAmount;
        }

        public String getShippingInvoiced() {
            return shippingInvoiced;
        }

        public void setShippingInvoiced(String shippingInvoiced) {
            this.shippingInvoiced = shippingInvoiced;
        }

        public String getShippingAmount() {
            return shippingAmount;
        }

        public void setShippingAmount(String shippingAmount) {
            this.shippingAmount = shippingAmount;
        }

        public String getGrandTotal() {
            return grandTotal;
        }

        public void setGrandTotal(String grandTotal) {
            this.grandTotal = grandTotal;
        }

        public String getDiscountInvoiced() {
            return discountInvoiced;
        }

        public void setDiscountInvoiced(String discountInvoiced) {
            this.discountInvoiced = discountInvoiced;
        }

        public String getDiscountAmount() {
            return discountAmount;
        }

        public void setDiscountAmount(String discountAmount) {
            this.discountAmount = discountAmount;
        }

        public String getBaseTotalPaid() {
            return baseTotalPaid;
        }

        public void setBaseTotalPaid(String baseTotalPaid) {
            this.baseTotalPaid = baseTotalPaid;
        }

        public String getBaseTotalInvoicedCost() {
            return baseTotalInvoicedCost;
        }

        public void setBaseTotalInvoicedCost(String baseTotalInvoicedCost) {
            this.baseTotalInvoicedCost = baseTotalInvoicedCost;
        }

        public String getBaseTotalInvoiced() {
            return baseTotalInvoiced;
        }

        public void setBaseTotalInvoiced(String baseTotalInvoiced) {
            this.baseTotalInvoiced = baseTotalInvoiced;
        }

        public String getBaseToOrderRate() {
            return baseToOrderRate;
        }

        public void setBaseToOrderRate(String baseToOrderRate) {
            this.baseToOrderRate = baseToOrderRate;
        }

        public String getBaseToGlobalRate() {
            return baseToGlobalRate;
        }

        public void setBaseToGlobalRate(String baseToGlobalRate) {
            this.baseToGlobalRate = baseToGlobalRate;
        }

        public String getBaseTaxInvoiced() {
            return baseTaxInvoiced;
        }

        public void setBaseTaxInvoiced(String baseTaxInvoiced) {
            this.baseTaxInvoiced = baseTaxInvoiced;
        }

        public String getBaseTaxAmount() {
            return baseTaxAmount;
        }

        public void setBaseTaxAmount(String baseTaxAmount) {
            this.baseTaxAmount = baseTaxAmount;
        }

        public String getBaseSubtotalInvoiced() {
            return baseSubtotalInvoiced;
        }

        public void setBaseSubtotalInvoiced(String baseSubtotalInvoiced) {
            this.baseSubtotalInvoiced = baseSubtotalInvoiced;
        }

        public String getBaseSubtotal() {
            return baseSubtotal;
        }

        public void setBaseSubtotal(String baseSubtotal) {
            this.baseSubtotal = baseSubtotal;
        }

        public String getBaseShippingTaxAmount() {
            return baseShippingTaxAmount;
        }

        public void setBaseShippingTaxAmount(String baseShippingTaxAmount) {
            this.baseShippingTaxAmount = baseShippingTaxAmount;
        }

        public String getBaseShippingInvoiced() {
            return baseShippingInvoiced;
        }

        public void setBaseShippingInvoiced(String baseShippingInvoiced) {
            this.baseShippingInvoiced = baseShippingInvoiced;
        }

        public String getBaseShippingAmount() {
            return baseShippingAmount;
        }

        public void setBaseShippingAmount(String baseShippingAmount) {
            this.baseShippingAmount = baseShippingAmount;
        }

        public String getBaseGrandTotal() {
            return baseGrandTotal;
        }

        public void setBaseGrandTotal(String baseGrandTotal) {
            this.baseGrandTotal = baseGrandTotal;
        }

        public String getBaseDiscountInvoiced() {
            return baseDiscountInvoiced;
        }

        public void setBaseDiscountInvoiced(String baseDiscountInvoiced) {
            this.baseDiscountInvoiced = baseDiscountInvoiced;
        }

        public String getBaseDiscountAmount() {
            return baseDiscountAmount;
        }

        public void setBaseDiscountAmount(String baseDiscountAmount) {
            this.baseDiscountAmount = baseDiscountAmount;
        }

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getStoreId() {
            return storeId;
        }

        public void setStoreId(String storeId) {
            this.storeId = storeId;
        }

        public String getIsVirtual() {
            return isVirtual;
        }

        public void setIsVirtual(String isVirtual) {
            this.isVirtual = isVirtual;
        }

        public String getShippingDescription() {
            return shippingDescription;
        }

        public void setShippingDescription(String shippingDescription) {
            this.shippingDescription = shippingDescription;
        }

        public String getProtectCode() {
            return protectCode;
        }

        public void setProtectCode(String protectCode) {
            this.protectCode = protectCode;
        }

        public String getCouponCode() {
            return couponCode;
        }

        public void setCouponCode(String couponCode) {
            this.couponCode = couponCode;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getEntityId() {
            return entityId;
        }

        public void setEntityId(String entityId) {
            this.entityId = entityId;
        }
    }

    public static class Canceled {
        @Expose
        @SerializedName("order_approval_status")
        public String orderApprovalStatus;
        @Expose
        @SerializedName("paypal_ipn_customer_notified")
        public String paypalIpnCustomerNotified;
        @Expose
        @SerializedName("coupon_rule_name")
        public String couponRuleName;
        @Expose
        @SerializedName("base_shipping_incl_tax")
        public String baseShippingInclTax;
        @Expose
        @SerializedName("shipping_incl_tax")
        public String shippingInclTax;
        @Expose
        @SerializedName("base_discount_tax_compensation_invoiced")
        public String baseDiscountTaxCompensationInvoiced;
        @Expose
        @SerializedName("discount_tax_compensation_invoiced")
        public String discountTaxCompensationInvoiced;
        @Expose
        @SerializedName("base_shipping_discount_tax_compensation_amnt")
        public String baseShippingDiscountTaxCompensationAmnt;
        @Expose
        @SerializedName("shipping_discount_tax_compensation_amount")
        public String shippingDiscountTaxCompensationAmount;
        @Expose
        @SerializedName("base_discount_tax_compensation_amount")
        public String baseDiscountTaxCompensationAmount;
        @Expose
        @SerializedName("discount_tax_compensation_amount")
        public String discountTaxCompensationAmount;
        @Expose
        @SerializedName("total_item_count")
        public String totalItemCount;
        @Expose
        @SerializedName("updated_at")
        public String updatedAt;
        @Expose
        @SerializedName("created_at")
        public String createdAt;
        @Expose
        @SerializedName("store_name")
        public String storeName;
        @Expose
        @SerializedName("store_currency_code")
        public String storeCurrencyCode;
        @Expose
        @SerializedName("shipping_method")
        public String shippingMethod;
        @Expose
        @SerializedName("remote_ip")
        public String remoteIp;
        @Expose
        @SerializedName("order_currency_code")
        public String orderCurrencyCode;
        @Expose
        @SerializedName("global_currency_code")
        public String globalCurrencyCode;
        @Expose
        @SerializedName("discount_description")
        public String discountDescription;
        @Expose
        @SerializedName("customer_lastname")
        public String customerLastname;
        @Expose
        @SerializedName("customer_firstname")
        public String customerFirstname;
        @Expose
        @SerializedName("customer_email")
        public String customerEmail;
        @Expose
        @SerializedName("base_currency_code")
        public String baseCurrencyCode;
        @Expose
        @SerializedName("applied_rule_ids")
        public String appliedRuleIds;
        @Expose
        @SerializedName("increment_id")
        public String incrementId;
        @Expose
        @SerializedName("weight")
        public String weight;
        @Expose
        @SerializedName("total_due")
        public String totalDue;
        @Expose
        @SerializedName("subtotal_incl_tax")
        public String subtotalInclTax;
        @Expose
        @SerializedName("shipping_discount_amount")
        public String shippingDiscountAmount;
        @Expose
        @SerializedName("base_total_due")
        public String baseTotalDue;
        @Expose
        @SerializedName("base_subtotal_incl_tax")
        public String baseSubtotalInclTax;
        @Expose
        @SerializedName("base_shipping_discount_amount")
        public String baseShippingDiscountAmount;
        @Expose
        @SerializedName("shipping_address_id")
        public String shippingAddressId;
        @Expose
        @SerializedName("quote_id")
        public String quoteId;
        @Expose
        @SerializedName("send_email")
        public String sendEmail;
        @Expose
        @SerializedName("email_sent")
        public String emailSent;
        @Expose
        @SerializedName("customer_group_id")
        public String customerGroupId;
        @Expose
        @SerializedName("billing_address_id")
        public String billingAddressId;
        @Expose
        @SerializedName("customer_note_notify")
        public String customerNoteNotify;
        @Expose
        @SerializedName("customer_is_guest")
        public String customerIsGuest;
        @Expose
        @SerializedName("total_qty_ordered")
        public String totalQtyOrdered;
        @Expose
        @SerializedName("total_paid")
        public String totalPaid;
        @Expose
        @SerializedName("total_invoiced")
        public String totalInvoiced;
        @Expose
        @SerializedName("tax_invoiced")
        public String taxInvoiced;
        @Expose
        @SerializedName("tax_amount")
        public String taxAmount;
        @Expose
        @SerializedName("subtotal_invoiced")
        public String subtotalInvoiced;
        @Expose
        @SerializedName("subtotal")
        public String subtotal;
        @Expose
        @SerializedName("store_to_order_rate")
        public String storeToOrderRate;
        @Expose
        @SerializedName("store_to_base_rate")
        public String storeToBaseRate;
        @Expose
        @SerializedName("shipping_tax_amount")
        public String shippingTaxAmount;
        @Expose
        @SerializedName("shipping_invoiced")
        public String shippingInvoiced;
        @Expose
        @SerializedName("shipping_amount")
        public String shippingAmount;
        @Expose
        @SerializedName("grand_total")
        public String grandTotal;
        @Expose
        @SerializedName("discount_invoiced")
        public String discountInvoiced;
        @Expose
        @SerializedName("discount_amount")
        public String discountAmount;
        @Expose
        @SerializedName("base_total_paid")
        public String baseTotalPaid;
        @Expose
        @SerializedName("base_total_invoiced_cost")
        public String baseTotalInvoicedCost;
        @Expose
        @SerializedName("base_total_invoiced")
        public String baseTotalInvoiced;
        @Expose
        @SerializedName("base_to_order_rate")
        public String baseToOrderRate;
        @Expose
        @SerializedName("base_to_global_rate")
        public String baseToGlobalRate;
        @Expose
        @SerializedName("base_tax_invoiced")
        public String baseTaxInvoiced;
        @Expose
        @SerializedName("base_tax_amount")
        public String baseTaxAmount;
        @Expose
        @SerializedName("base_subtotal_invoiced")
        public String baseSubtotalInvoiced;
        @Expose
        @SerializedName("base_subtotal")
        public String baseSubtotal;
        @Expose
        @SerializedName("base_shipping_tax_amount")
        public String baseShippingTaxAmount;
        @Expose
        @SerializedName("base_shipping_invoiced")
        public String baseShippingInvoiced;
        @Expose
        @SerializedName("base_shipping_amount")
        public String baseShippingAmount;
        @Expose
        @SerializedName("base_grand_total")
        public String baseGrandTotal;
        @Expose
        @SerializedName("base_discount_invoiced")
        public String baseDiscountInvoiced;
        @Expose
        @SerializedName("base_discount_amount")
        public String baseDiscountAmount;
        @Expose
        @SerializedName("customer_id")
        public String customerId;
        @Expose
        @SerializedName("store_id")
        public String storeId;
        @Expose
        @SerializedName("is_virtual")
        public String isVirtual;
        @Expose
        @SerializedName("shipping_description")
        public String shippingDescription;
        @Expose
        @SerializedName("protect_code")
        public String protectCode;
        @Expose
        @SerializedName("coupon_code")
        public String couponCode;
        @Expose
        @SerializedName("status")
        public String status;
        @Expose
        @SerializedName("state")
        public String state;
        @Expose
        @SerializedName("entity_id")
        public String entityId;

        public Canceled(String customerLastname, String customerFirstname, String status, String entityId, String grand_total) {
            this.customerLastname = customerLastname;
            this.customerFirstname = customerFirstname;
            this.status = status;
            this.entityId = entityId;
            this.grandTotal = grand_total;
        }

        public String getOrderApprovalStatus() {
            return orderApprovalStatus;
        }

        public void setOrderApprovalStatus(String orderApprovalStatus) {
            this.orderApprovalStatus = orderApprovalStatus;
        }

        public String getPaypalIpnCustomerNotified() {
            return paypalIpnCustomerNotified;
        }

        public void setPaypalIpnCustomerNotified(String paypalIpnCustomerNotified) {
            this.paypalIpnCustomerNotified = paypalIpnCustomerNotified;
        }

        public String getCouponRuleName() {
            return couponRuleName;
        }

        public void setCouponRuleName(String couponRuleName) {
            this.couponRuleName = couponRuleName;
        }

        public String getBaseShippingInclTax() {
            return baseShippingInclTax;
        }

        public void setBaseShippingInclTax(String baseShippingInclTax) {
            this.baseShippingInclTax = baseShippingInclTax;
        }

        public String getShippingInclTax() {
            return shippingInclTax;
        }

        public void setShippingInclTax(String shippingInclTax) {
            this.shippingInclTax = shippingInclTax;
        }

        public String getBaseDiscountTaxCompensationInvoiced() {
            return baseDiscountTaxCompensationInvoiced;
        }

        public void setBaseDiscountTaxCompensationInvoiced(String baseDiscountTaxCompensationInvoiced) {
            this.baseDiscountTaxCompensationInvoiced = baseDiscountTaxCompensationInvoiced;
        }

        public String getDiscountTaxCompensationInvoiced() {
            return discountTaxCompensationInvoiced;
        }

        public void setDiscountTaxCompensationInvoiced(String discountTaxCompensationInvoiced) {
            this.discountTaxCompensationInvoiced = discountTaxCompensationInvoiced;
        }

        public String getBaseShippingDiscountTaxCompensationAmnt() {
            return baseShippingDiscountTaxCompensationAmnt;
        }

        public void setBaseShippingDiscountTaxCompensationAmnt(String baseShippingDiscountTaxCompensationAmnt) {
            this.baseShippingDiscountTaxCompensationAmnt = baseShippingDiscountTaxCompensationAmnt;
        }

        public String getShippingDiscountTaxCompensationAmount() {
            return shippingDiscountTaxCompensationAmount;
        }

        public void setShippingDiscountTaxCompensationAmount(String shippingDiscountTaxCompensationAmount) {
            this.shippingDiscountTaxCompensationAmount = shippingDiscountTaxCompensationAmount;
        }

        public String getBaseDiscountTaxCompensationAmount() {
            return baseDiscountTaxCompensationAmount;
        }

        public void setBaseDiscountTaxCompensationAmount(String baseDiscountTaxCompensationAmount) {
            this.baseDiscountTaxCompensationAmount = baseDiscountTaxCompensationAmount;
        }

        public String getDiscountTaxCompensationAmount() {
            return discountTaxCompensationAmount;
        }

        public void setDiscountTaxCompensationAmount(String discountTaxCompensationAmount) {
            this.discountTaxCompensationAmount = discountTaxCompensationAmount;
        }

        public String getTotalItemCount() {
            return totalItemCount;
        }

        public void setTotalItemCount(String totalItemCount) {
            this.totalItemCount = totalItemCount;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getStoreName() {
            return storeName;
        }

        public void setStoreName(String storeName) {
            this.storeName = storeName;
        }

        public String getStoreCurrencyCode() {
            return storeCurrencyCode;
        }

        public void setStoreCurrencyCode(String storeCurrencyCode) {
            this.storeCurrencyCode = storeCurrencyCode;
        }

        public String getShippingMethod() {
            return shippingMethod;
        }

        public void setShippingMethod(String shippingMethod) {
            this.shippingMethod = shippingMethod;
        }

        public String getRemoteIp() {
            return remoteIp;
        }

        public void setRemoteIp(String remoteIp) {
            this.remoteIp = remoteIp;
        }

        public String getOrderCurrencyCode() {
            return orderCurrencyCode;
        }

        public void setOrderCurrencyCode(String orderCurrencyCode) {
            this.orderCurrencyCode = orderCurrencyCode;
        }

        public String getGlobalCurrencyCode() {
            return globalCurrencyCode;
        }

        public void setGlobalCurrencyCode(String globalCurrencyCode) {
            this.globalCurrencyCode = globalCurrencyCode;
        }

        public String getDiscountDescription() {
            return discountDescription;
        }

        public void setDiscountDescription(String discountDescription) {
            this.discountDescription = discountDescription;
        }

        public String getCustomerLastname() {
            return customerLastname;
        }

        public void setCustomerLastname(String customerLastname) {
            this.customerLastname = customerLastname;
        }

        public String getCustomerFirstname() {
            return customerFirstname;
        }

        public void setCustomerFirstname(String customerFirstname) {
            this.customerFirstname = customerFirstname;
        }

        public String getCustomerEmail() {
            return customerEmail;
        }

        public void setCustomerEmail(String customerEmail) {
            this.customerEmail = customerEmail;
        }

        public String getBaseCurrencyCode() {
            return baseCurrencyCode;
        }

        public void setBaseCurrencyCode(String baseCurrencyCode) {
            this.baseCurrencyCode = baseCurrencyCode;
        }

        public String getAppliedRuleIds() {
            return appliedRuleIds;
        }

        public void setAppliedRuleIds(String appliedRuleIds) {
            this.appliedRuleIds = appliedRuleIds;
        }

        public String getIncrementId() {
            return incrementId;
        }

        public void setIncrementId(String incrementId) {
            this.incrementId = incrementId;
        }

        public String getWeight() {
            return weight;
        }

        public void setWeight(String weight) {
            this.weight = weight;
        }

        public String getTotalDue() {
            return totalDue;
        }

        public void setTotalDue(String totalDue) {
            this.totalDue = totalDue;
        }

        public String getSubtotalInclTax() {
            return subtotalInclTax;
        }

        public void setSubtotalInclTax(String subtotalInclTax) {
            this.subtotalInclTax = subtotalInclTax;
        }

        public String getShippingDiscountAmount() {
            return shippingDiscountAmount;
        }

        public void setShippingDiscountAmount(String shippingDiscountAmount) {
            this.shippingDiscountAmount = shippingDiscountAmount;
        }

        public String getBaseTotalDue() {
            return baseTotalDue;
        }

        public void setBaseTotalDue(String baseTotalDue) {
            this.baseTotalDue = baseTotalDue;
        }

        public String getBaseSubtotalInclTax() {
            return baseSubtotalInclTax;
        }

        public void setBaseSubtotalInclTax(String baseSubtotalInclTax) {
            this.baseSubtotalInclTax = baseSubtotalInclTax;
        }

        public String getBaseShippingDiscountAmount() {
            return baseShippingDiscountAmount;
        }

        public void setBaseShippingDiscountAmount(String baseShippingDiscountAmount) {
            this.baseShippingDiscountAmount = baseShippingDiscountAmount;
        }

        public String getShippingAddressId() {
            return shippingAddressId;
        }

        public void setShippingAddressId(String shippingAddressId) {
            this.shippingAddressId = shippingAddressId;
        }

        public String getQuoteId() {
            return quoteId;
        }

        public void setQuoteId(String quoteId) {
            this.quoteId = quoteId;
        }

        public String getSendEmail() {
            return sendEmail;
        }

        public void setSendEmail(String sendEmail) {
            this.sendEmail = sendEmail;
        }

        public String getEmailSent() {
            return emailSent;
        }

        public void setEmailSent(String emailSent) {
            this.emailSent = emailSent;
        }

        public String getCustomerGroupId() {
            return customerGroupId;
        }

        public void setCustomerGroupId(String customerGroupId) {
            this.customerGroupId = customerGroupId;
        }

        public String getBillingAddressId() {
            return billingAddressId;
        }

        public void setBillingAddressId(String billingAddressId) {
            this.billingAddressId = billingAddressId;
        }

        public String getCustomerNoteNotify() {
            return customerNoteNotify;
        }

        public void setCustomerNoteNotify(String customerNoteNotify) {
            this.customerNoteNotify = customerNoteNotify;
        }

        public String getCustomerIsGuest() {
            return customerIsGuest;
        }

        public void setCustomerIsGuest(String customerIsGuest) {
            this.customerIsGuest = customerIsGuest;
        }

        public String getTotalQtyOrdered() {
            return totalQtyOrdered;
        }

        public void setTotalQtyOrdered(String totalQtyOrdered) {
            this.totalQtyOrdered = totalQtyOrdered;
        }

        public String getTotalPaid() {
            return totalPaid;
        }

        public void setTotalPaid(String totalPaid) {
            this.totalPaid = totalPaid;
        }

        public String getTotalInvoiced() {
            return totalInvoiced;
        }

        public void setTotalInvoiced(String totalInvoiced) {
            this.totalInvoiced = totalInvoiced;
        }

        public String getTaxInvoiced() {
            return taxInvoiced;
        }

        public void setTaxInvoiced(String taxInvoiced) {
            this.taxInvoiced = taxInvoiced;
        }

        public String getTaxAmount() {
            return taxAmount;
        }

        public void setTaxAmount(String taxAmount) {
            this.taxAmount = taxAmount;
        }

        public String getSubtotalInvoiced() {
            return subtotalInvoiced;
        }

        public void setSubtotalInvoiced(String subtotalInvoiced) {
            this.subtotalInvoiced = subtotalInvoiced;
        }

        public String getSubtotal() {
            return subtotal;
        }

        public void setSubtotal(String subtotal) {
            this.subtotal = subtotal;
        }

        public String getStoreToOrderRate() {
            return storeToOrderRate;
        }

        public void setStoreToOrderRate(String storeToOrderRate) {
            this.storeToOrderRate = storeToOrderRate;
        }

        public String getStoreToBaseRate() {
            return storeToBaseRate;
        }

        public void setStoreToBaseRate(String storeToBaseRate) {
            this.storeToBaseRate = storeToBaseRate;
        }

        public String getShippingTaxAmount() {
            return shippingTaxAmount;
        }

        public void setShippingTaxAmount(String shippingTaxAmount) {
            this.shippingTaxAmount = shippingTaxAmount;
        }

        public String getShippingInvoiced() {
            return shippingInvoiced;
        }

        public void setShippingInvoiced(String shippingInvoiced) {
            this.shippingInvoiced = shippingInvoiced;
        }

        public String getShippingAmount() {
            return shippingAmount;
        }

        public void setShippingAmount(String shippingAmount) {
            this.shippingAmount = shippingAmount;
        }

        public String getGrandTotal() {
            return grandTotal;
        }

        public void setGrandTotal(String grandTotal) {
            this.grandTotal = grandTotal;
        }

        public String getDiscountInvoiced() {
            return discountInvoiced;
        }

        public void setDiscountInvoiced(String discountInvoiced) {
            this.discountInvoiced = discountInvoiced;
        }

        public String getDiscountAmount() {
            return discountAmount;
        }

        public void setDiscountAmount(String discountAmount) {
            this.discountAmount = discountAmount;
        }

        public String getBaseTotalPaid() {
            return baseTotalPaid;
        }

        public void setBaseTotalPaid(String baseTotalPaid) {
            this.baseTotalPaid = baseTotalPaid;
        }

        public String getBaseTotalInvoicedCost() {
            return baseTotalInvoicedCost;
        }

        public void setBaseTotalInvoicedCost(String baseTotalInvoicedCost) {
            this.baseTotalInvoicedCost = baseTotalInvoicedCost;
        }

        public String getBaseTotalInvoiced() {
            return baseTotalInvoiced;
        }

        public void setBaseTotalInvoiced(String baseTotalInvoiced) {
            this.baseTotalInvoiced = baseTotalInvoiced;
        }

        public String getBaseToOrderRate() {
            return baseToOrderRate;
        }

        public void setBaseToOrderRate(String baseToOrderRate) {
            this.baseToOrderRate = baseToOrderRate;
        }

        public String getBaseToGlobalRate() {
            return baseToGlobalRate;
        }

        public void setBaseToGlobalRate(String baseToGlobalRate) {
            this.baseToGlobalRate = baseToGlobalRate;
        }

        public String getBaseTaxInvoiced() {
            return baseTaxInvoiced;
        }

        public void setBaseTaxInvoiced(String baseTaxInvoiced) {
            this.baseTaxInvoiced = baseTaxInvoiced;
        }

        public String getBaseTaxAmount() {
            return baseTaxAmount;
        }

        public void setBaseTaxAmount(String baseTaxAmount) {
            this.baseTaxAmount = baseTaxAmount;
        }

        public String getBaseSubtotalInvoiced() {
            return baseSubtotalInvoiced;
        }

        public void setBaseSubtotalInvoiced(String baseSubtotalInvoiced) {
            this.baseSubtotalInvoiced = baseSubtotalInvoiced;
        }

        public String getBaseSubtotal() {
            return baseSubtotal;
        }

        public void setBaseSubtotal(String baseSubtotal) {
            this.baseSubtotal = baseSubtotal;
        }

        public String getBaseShippingTaxAmount() {
            return baseShippingTaxAmount;
        }

        public void setBaseShippingTaxAmount(String baseShippingTaxAmount) {
            this.baseShippingTaxAmount = baseShippingTaxAmount;
        }

        public String getBaseShippingInvoiced() {
            return baseShippingInvoiced;
        }

        public void setBaseShippingInvoiced(String baseShippingInvoiced) {
            this.baseShippingInvoiced = baseShippingInvoiced;
        }

        public String getBaseShippingAmount() {
            return baseShippingAmount;
        }

        public void setBaseShippingAmount(String baseShippingAmount) {
            this.baseShippingAmount = baseShippingAmount;
        }

        public String getBaseGrandTotal() {
            return baseGrandTotal;
        }

        public void setBaseGrandTotal(String baseGrandTotal) {
            this.baseGrandTotal = baseGrandTotal;
        }

        public String getBaseDiscountInvoiced() {
            return baseDiscountInvoiced;
        }

        public void setBaseDiscountInvoiced(String baseDiscountInvoiced) {
            this.baseDiscountInvoiced = baseDiscountInvoiced;
        }

        public String getBaseDiscountAmount() {
            return baseDiscountAmount;
        }

        public void setBaseDiscountAmount(String baseDiscountAmount) {
            this.baseDiscountAmount = baseDiscountAmount;
        }

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getStoreId() {
            return storeId;
        }

        public void setStoreId(String storeId) {
            this.storeId = storeId;
        }

        public String getIsVirtual() {
            return isVirtual;
        }

        public void setIsVirtual(String isVirtual) {
            this.isVirtual = isVirtual;
        }

        public String getShippingDescription() {
            return shippingDescription;
        }

        public void setShippingDescription(String shippingDescription) {
            this.shippingDescription = shippingDescription;
        }

        public String getProtectCode() {
            return protectCode;
        }

        public void setProtectCode(String protectCode) {
            this.protectCode = protectCode;
        }

        public String getCouponCode() {
            return couponCode;
        }

        public void setCouponCode(String couponCode) {
            this.couponCode = couponCode;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getEntityId() {
            return entityId;
        }

        public void setEntityId(String entityId) {
            this.entityId = entityId;
        }
    }

    public static class Pending {
        @Expose
        @SerializedName("order_approval_status")
        public String orderApprovalStatus;
        @Expose
        @SerializedName("paypal_ipn_customer_notified")
        public String paypalIpnCustomerNotified;
        @Expose
        @SerializedName("coupon_rule_name")
        public String couponRuleName;
        @Expose
        @SerializedName("base_shipping_incl_tax")
        public String baseShippingInclTax;
        @Expose
        @SerializedName("shipping_incl_tax")
        public String shippingInclTax;
        @Expose
        @SerializedName("base_discount_tax_compensation_invoiced")
        public String baseDiscountTaxCompensationInvoiced;
        @Expose
        @SerializedName("discount_tax_compensation_invoiced")
        public String discountTaxCompensationInvoiced;
        @Expose
        @SerializedName("base_shipping_discount_tax_compensation_amnt")
        public String baseShippingDiscountTaxCompensationAmnt;
        @Expose
        @SerializedName("shipping_discount_tax_compensation_amount")
        public String shippingDiscountTaxCompensationAmount;
        @Expose
        @SerializedName("base_discount_tax_compensation_amount")
        public String baseDiscountTaxCompensationAmount;
        @Expose
        @SerializedName("discount_tax_compensation_amount")
        public String discountTaxCompensationAmount;
        @Expose
        @SerializedName("total_item_count")
        public String totalItemCount;
        @Expose
        @SerializedName("updated_at")
        public String updatedAt;
        @Expose
        @SerializedName("created_at")
        public String createdAt;
        @Expose
        @SerializedName("store_name")
        public String storeName;
        @Expose
        @SerializedName("store_currency_code")
        public String storeCurrencyCode;
        @Expose
        @SerializedName("shipping_method")
        public String shippingMethod;
        @Expose
        @SerializedName("remote_ip")
        public String remoteIp;
        @Expose
        @SerializedName("order_currency_code")
        public String orderCurrencyCode;
        @Expose
        @SerializedName("global_currency_code")
        public String globalCurrencyCode;
        @Expose
        @SerializedName("discount_description")
        public String discountDescription;
        @Expose
        @SerializedName("customer_lastname")
        public String customerLastname;
        @Expose
        @SerializedName("customer_firstname")
        public String customerFirstname;
        @Expose
        @SerializedName("customer_email")
        public String customerEmail;
        @Expose
        @SerializedName("base_currency_code")
        public String baseCurrencyCode;
        @Expose
        @SerializedName("applied_rule_ids")
        public String appliedRuleIds;
        @Expose
        @SerializedName("increment_id")
        public String incrementId;
        @Expose
        @SerializedName("weight")
        public String weight;
        @Expose
        @SerializedName("total_due")
        public String totalDue;
        @Expose
        @SerializedName("subtotal_incl_tax")
        public String subtotalInclTax;
        @Expose
        @SerializedName("shipping_discount_amount")
        public String shippingDiscountAmount;
        @Expose
        @SerializedName("base_total_due")
        public String baseTotalDue;
        @Expose
        @SerializedName("base_subtotal_incl_tax")
        public String baseSubtotalInclTax;
        @Expose
        @SerializedName("base_shipping_discount_amount")
        public String baseShippingDiscountAmount;
        @Expose
        @SerializedName("shipping_address_id")
        public String shippingAddressId;
        @Expose
        @SerializedName("quote_id")
        public String quoteId;
        @Expose
        @SerializedName("send_email")
        public String sendEmail;
        @Expose
        @SerializedName("email_sent")
        public String emailSent;
        @Expose
        @SerializedName("customer_group_id")
        public String customerGroupId;
        @Expose
        @SerializedName("billing_address_id")
        public String billingAddressId;
        @Expose
        @SerializedName("customer_note_notify")
        public String customerNoteNotify;
        @Expose
        @SerializedName("customer_is_guest")
        public String customerIsGuest;
        @Expose
        @SerializedName("total_qty_ordered")
        public String totalQtyOrdered;
        @Expose
        @SerializedName("total_paid")
        public String totalPaid;
        @Expose
        @SerializedName("total_invoiced")
        public String totalInvoiced;
        @Expose
        @SerializedName("tax_invoiced")
        public String taxInvoiced;
        @Expose
        @SerializedName("tax_amount")
        public String taxAmount;
        @Expose
        @SerializedName("subtotal_invoiced")
        public String subtotalInvoiced;
        @Expose
        @SerializedName("subtotal")
        public String subtotal;
        @Expose
        @SerializedName("store_to_order_rate")
        public String storeToOrderRate;
        @Expose
        @SerializedName("store_to_base_rate")
        public String storeToBaseRate;
        @Expose
        @SerializedName("shipping_tax_amount")
        public String shippingTaxAmount;
        @Expose
        @SerializedName("shipping_invoiced")
        public String shippingInvoiced;
        @Expose
        @SerializedName("shipping_amount")
        public String shippingAmount;
        @Expose
        @SerializedName("grand_total")
        public String grandTotal;
        @Expose
        @SerializedName("discount_invoiced")
        public String discountInvoiced;
        @Expose
        @SerializedName("discount_amount")
        public String discountAmount;
        @Expose
        @SerializedName("base_total_paid")
        public String baseTotalPaid;
        @Expose
        @SerializedName("base_total_invoiced_cost")
        public String baseTotalInvoicedCost;
        @Expose
        @SerializedName("base_total_invoiced")
        public String baseTotalInvoiced;
        @Expose
        @SerializedName("base_to_order_rate")
        public String baseToOrderRate;
        @Expose
        @SerializedName("base_to_global_rate")
        public String baseToGlobalRate;
        @Expose
        @SerializedName("base_tax_invoiced")
        public String baseTaxInvoiced;
        @Expose
        @SerializedName("base_tax_amount")
        public String baseTaxAmount;
        @Expose
        @SerializedName("base_subtotal_invoiced")
        public String baseSubtotalInvoiced;
        @Expose
        @SerializedName("base_subtotal")
        public String baseSubtotal;
        @Expose
        @SerializedName("base_shipping_tax_amount")
        public String baseShippingTaxAmount;
        @Expose
        @SerializedName("base_shipping_invoiced")
        public String baseShippingInvoiced;
        @Expose
        @SerializedName("base_shipping_amount")
        public String baseShippingAmount;
        @Expose
        @SerializedName("base_grand_total")
        public String baseGrandTotal;
        @Expose
        @SerializedName("base_discount_invoiced")
        public String baseDiscountInvoiced;
        @Expose
        @SerializedName("base_discount_amount")
        public String baseDiscountAmount;
        @Expose
        @SerializedName("customer_id")
        public String customerId;
        @Expose
        @SerializedName("store_id")
        public String storeId;
        @Expose
        @SerializedName("is_virtual")
        public String isVirtual;
        @Expose
        @SerializedName("shipping_description")
        public String shippingDescription;
        @Expose
        @SerializedName("protect_code")
        public String protectCode;
        @Expose
        @SerializedName("coupon_code")
        public String couponCode;
        @Expose
        @SerializedName("status")
        public String status;
        @Expose
        @SerializedName("state")
        public String state;
        @Expose
        @SerializedName("entity_id")
        public String entityId;


        public Pending(String customerLastname, String customerFirstname, String status, String entityId, String grand_total) {
            this.customerLastname = customerLastname;
            this.customerFirstname = customerFirstname;
            this.status = status;
            this.entityId = entityId;
            this.grandTotal = grand_total;
        }

        public String getOrderApprovalStatus() {
            return orderApprovalStatus;
        }

        public void setOrderApprovalStatus(String orderApprovalStatus) {
            this.orderApprovalStatus = orderApprovalStatus;
        }

        public String getPaypalIpnCustomerNotified() {
            return paypalIpnCustomerNotified;
        }

        public void setPaypalIpnCustomerNotified(String paypalIpnCustomerNotified) {
            this.paypalIpnCustomerNotified = paypalIpnCustomerNotified;
        }

        public String getCouponRuleName() {
            return couponRuleName;
        }

        public void setCouponRuleName(String couponRuleName) {
            this.couponRuleName = couponRuleName;
        }

        public String getBaseShippingInclTax() {
            return baseShippingInclTax;
        }

        public void setBaseShippingInclTax(String baseShippingInclTax) {
            this.baseShippingInclTax = baseShippingInclTax;
        }

        public String getShippingInclTax() {
            return shippingInclTax;
        }

        public void setShippingInclTax(String shippingInclTax) {
            this.shippingInclTax = shippingInclTax;
        }

        public String getBaseDiscountTaxCompensationInvoiced() {
            return baseDiscountTaxCompensationInvoiced;
        }

        public void setBaseDiscountTaxCompensationInvoiced(String baseDiscountTaxCompensationInvoiced) {
            this.baseDiscountTaxCompensationInvoiced = baseDiscountTaxCompensationInvoiced;
        }

        public String getDiscountTaxCompensationInvoiced() {
            return discountTaxCompensationInvoiced;
        }

        public void setDiscountTaxCompensationInvoiced(String discountTaxCompensationInvoiced) {
            this.discountTaxCompensationInvoiced = discountTaxCompensationInvoiced;
        }

        public String getBaseShippingDiscountTaxCompensationAmnt() {
            return baseShippingDiscountTaxCompensationAmnt;
        }

        public void setBaseShippingDiscountTaxCompensationAmnt(String baseShippingDiscountTaxCompensationAmnt) {
            this.baseShippingDiscountTaxCompensationAmnt = baseShippingDiscountTaxCompensationAmnt;
        }

        public String getShippingDiscountTaxCompensationAmount() {
            return shippingDiscountTaxCompensationAmount;
        }

        public void setShippingDiscountTaxCompensationAmount(String shippingDiscountTaxCompensationAmount) {
            this.shippingDiscountTaxCompensationAmount = shippingDiscountTaxCompensationAmount;
        }

        public String getBaseDiscountTaxCompensationAmount() {
            return baseDiscountTaxCompensationAmount;
        }

        public void setBaseDiscountTaxCompensationAmount(String baseDiscountTaxCompensationAmount) {
            this.baseDiscountTaxCompensationAmount = baseDiscountTaxCompensationAmount;
        }

        public String getDiscountTaxCompensationAmount() {
            return discountTaxCompensationAmount;
        }

        public void setDiscountTaxCompensationAmount(String discountTaxCompensationAmount) {
            this.discountTaxCompensationAmount = discountTaxCompensationAmount;
        }

        public String getTotalItemCount() {
            return totalItemCount;
        }

        public void setTotalItemCount(String totalItemCount) {
            this.totalItemCount = totalItemCount;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getStoreName() {
            return storeName;
        }

        public void setStoreName(String storeName) {
            this.storeName = storeName;
        }

        public String getStoreCurrencyCode() {
            return storeCurrencyCode;
        }

        public void setStoreCurrencyCode(String storeCurrencyCode) {
            this.storeCurrencyCode = storeCurrencyCode;
        }

        public String getShippingMethod() {
            return shippingMethod;
        }

        public void setShippingMethod(String shippingMethod) {
            this.shippingMethod = shippingMethod;
        }

        public String getRemoteIp() {
            return remoteIp;
        }

        public void setRemoteIp(String remoteIp) {
            this.remoteIp = remoteIp;
        }

        public String getOrderCurrencyCode() {
            return orderCurrencyCode;
        }

        public void setOrderCurrencyCode(String orderCurrencyCode) {
            this.orderCurrencyCode = orderCurrencyCode;
        }

        public String getGlobalCurrencyCode() {
            return globalCurrencyCode;
        }

        public void setGlobalCurrencyCode(String globalCurrencyCode) {
            this.globalCurrencyCode = globalCurrencyCode;
        }

        public String getDiscountDescription() {
            return discountDescription;
        }

        public void setDiscountDescription(String discountDescription) {
            this.discountDescription = discountDescription;
        }

        public String getCustomerLastname() {
            return customerLastname;
        }

        public void setCustomerLastname(String customerLastname) {
            this.customerLastname = customerLastname;
        }

        public String getCustomerFirstname() {
            return customerFirstname;
        }

        public void setCustomerFirstname(String customerFirstname) {
            this.customerFirstname = customerFirstname;
        }

        public String getCustomerEmail() {
            return customerEmail;
        }

        public void setCustomerEmail(String customerEmail) {
            this.customerEmail = customerEmail;
        }

        public String getBaseCurrencyCode() {
            return baseCurrencyCode;
        }

        public void setBaseCurrencyCode(String baseCurrencyCode) {
            this.baseCurrencyCode = baseCurrencyCode;
        }

        public String getAppliedRuleIds() {
            return appliedRuleIds;
        }

        public void setAppliedRuleIds(String appliedRuleIds) {
            this.appliedRuleIds = appliedRuleIds;
        }

        public String getIncrementId() {
            return incrementId;
        }

        public void setIncrementId(String incrementId) {
            this.incrementId = incrementId;
        }

        public String getWeight() {
            return weight;
        }

        public void setWeight(String weight) {
            this.weight = weight;
        }

        public String getTotalDue() {
            return totalDue;
        }

        public void setTotalDue(String totalDue) {
            this.totalDue = totalDue;
        }

        public String getSubtotalInclTax() {
            return subtotalInclTax;
        }

        public void setSubtotalInclTax(String subtotalInclTax) {
            this.subtotalInclTax = subtotalInclTax;
        }

        public String getShippingDiscountAmount() {
            return shippingDiscountAmount;
        }

        public void setShippingDiscountAmount(String shippingDiscountAmount) {
            this.shippingDiscountAmount = shippingDiscountAmount;
        }

        public String getBaseTotalDue() {
            return baseTotalDue;
        }

        public void setBaseTotalDue(String baseTotalDue) {
            this.baseTotalDue = baseTotalDue;
        }

        public String getBaseSubtotalInclTax() {
            return baseSubtotalInclTax;
        }

        public void setBaseSubtotalInclTax(String baseSubtotalInclTax) {
            this.baseSubtotalInclTax = baseSubtotalInclTax;
        }

        public String getBaseShippingDiscountAmount() {
            return baseShippingDiscountAmount;
        }

        public void setBaseShippingDiscountAmount(String baseShippingDiscountAmount) {
            this.baseShippingDiscountAmount = baseShippingDiscountAmount;
        }

        public String getShippingAddressId() {
            return shippingAddressId;
        }

        public void setShippingAddressId(String shippingAddressId) {
            this.shippingAddressId = shippingAddressId;
        }

        public String getQuoteId() {
            return quoteId;
        }

        public void setQuoteId(String quoteId) {
            this.quoteId = quoteId;
        }

        public String getSendEmail() {
            return sendEmail;
        }

        public void setSendEmail(String sendEmail) {
            this.sendEmail = sendEmail;
        }

        public String getEmailSent() {
            return emailSent;
        }

        public void setEmailSent(String emailSent) {
            this.emailSent = emailSent;
        }

        public String getCustomerGroupId() {
            return customerGroupId;
        }

        public void setCustomerGroupId(String customerGroupId) {
            this.customerGroupId = customerGroupId;
        }

        public String getBillingAddressId() {
            return billingAddressId;
        }

        public void setBillingAddressId(String billingAddressId) {
            this.billingAddressId = billingAddressId;
        }

        public String getCustomerNoteNotify() {
            return customerNoteNotify;
        }

        public void setCustomerNoteNotify(String customerNoteNotify) {
            this.customerNoteNotify = customerNoteNotify;
        }

        public String getCustomerIsGuest() {
            return customerIsGuest;
        }

        public void setCustomerIsGuest(String customerIsGuest) {
            this.customerIsGuest = customerIsGuest;
        }

        public String getTotalQtyOrdered() {
            return totalQtyOrdered;
        }

        public void setTotalQtyOrdered(String totalQtyOrdered) {
            this.totalQtyOrdered = totalQtyOrdered;
        }

        public String getTotalPaid() {
            return totalPaid;
        }

        public void setTotalPaid(String totalPaid) {
            this.totalPaid = totalPaid;
        }

        public String getTotalInvoiced() {
            return totalInvoiced;
        }

        public void setTotalInvoiced(String totalInvoiced) {
            this.totalInvoiced = totalInvoiced;
        }

        public String getTaxInvoiced() {
            return taxInvoiced;
        }

        public void setTaxInvoiced(String taxInvoiced) {
            this.taxInvoiced = taxInvoiced;
        }

        public String getTaxAmount() {
            return taxAmount;
        }

        public void setTaxAmount(String taxAmount) {
            this.taxAmount = taxAmount;
        }

        public String getSubtotalInvoiced() {
            return subtotalInvoiced;
        }

        public void setSubtotalInvoiced(String subtotalInvoiced) {
            this.subtotalInvoiced = subtotalInvoiced;
        }

        public String getSubtotal() {
            return subtotal;
        }

        public void setSubtotal(String subtotal) {
            this.subtotal = subtotal;
        }

        public String getStoreToOrderRate() {
            return storeToOrderRate;
        }

        public void setStoreToOrderRate(String storeToOrderRate) {
            this.storeToOrderRate = storeToOrderRate;
        }

        public String getStoreToBaseRate() {
            return storeToBaseRate;
        }

        public void setStoreToBaseRate(String storeToBaseRate) {
            this.storeToBaseRate = storeToBaseRate;
        }

        public String getShippingTaxAmount() {
            return shippingTaxAmount;
        }

        public void setShippingTaxAmount(String shippingTaxAmount) {
            this.shippingTaxAmount = shippingTaxAmount;
        }

        public String getShippingInvoiced() {
            return shippingInvoiced;
        }

        public void setShippingInvoiced(String shippingInvoiced) {
            this.shippingInvoiced = shippingInvoiced;
        }

        public String getShippingAmount() {
            return shippingAmount;
        }

        public void setShippingAmount(String shippingAmount) {
            this.shippingAmount = shippingAmount;
        }

        public String getGrandTotal() {
            return grandTotal;
        }

        public void setGrandTotal(String grandTotal) {
            this.grandTotal = grandTotal;
        }

        public String getDiscountInvoiced() {
            return discountInvoiced;
        }

        public void setDiscountInvoiced(String discountInvoiced) {
            this.discountInvoiced = discountInvoiced;
        }

        public String getDiscountAmount() {
            return discountAmount;
        }

        public void setDiscountAmount(String discountAmount) {
            this.discountAmount = discountAmount;
        }

        public String getBaseTotalPaid() {
            return baseTotalPaid;
        }

        public void setBaseTotalPaid(String baseTotalPaid) {
            this.baseTotalPaid = baseTotalPaid;
        }

        public String getBaseTotalInvoicedCost() {
            return baseTotalInvoicedCost;
        }

        public void setBaseTotalInvoicedCost(String baseTotalInvoicedCost) {
            this.baseTotalInvoicedCost = baseTotalInvoicedCost;
        }

        public String getBaseTotalInvoiced() {
            return baseTotalInvoiced;
        }

        public void setBaseTotalInvoiced(String baseTotalInvoiced) {
            this.baseTotalInvoiced = baseTotalInvoiced;
        }

        public String getBaseToOrderRate() {
            return baseToOrderRate;
        }

        public void setBaseToOrderRate(String baseToOrderRate) {
            this.baseToOrderRate = baseToOrderRate;
        }

        public String getBaseToGlobalRate() {
            return baseToGlobalRate;
        }

        public void setBaseToGlobalRate(String baseToGlobalRate) {
            this.baseToGlobalRate = baseToGlobalRate;
        }

        public String getBaseTaxInvoiced() {
            return baseTaxInvoiced;
        }

        public void setBaseTaxInvoiced(String baseTaxInvoiced) {
            this.baseTaxInvoiced = baseTaxInvoiced;
        }

        public String getBaseTaxAmount() {
            return baseTaxAmount;
        }

        public void setBaseTaxAmount(String baseTaxAmount) {
            this.baseTaxAmount = baseTaxAmount;
        }

        public String getBaseSubtotalInvoiced() {
            return baseSubtotalInvoiced;
        }

        public void setBaseSubtotalInvoiced(String baseSubtotalInvoiced) {
            this.baseSubtotalInvoiced = baseSubtotalInvoiced;
        }

        public String getBaseSubtotal() {
            return baseSubtotal;
        }

        public void setBaseSubtotal(String baseSubtotal) {
            this.baseSubtotal = baseSubtotal;
        }

        public String getBaseShippingTaxAmount() {
            return baseShippingTaxAmount;
        }

        public void setBaseShippingTaxAmount(String baseShippingTaxAmount) {
            this.baseShippingTaxAmount = baseShippingTaxAmount;
        }

        public String getBaseShippingInvoiced() {
            return baseShippingInvoiced;
        }

        public void setBaseShippingInvoiced(String baseShippingInvoiced) {
            this.baseShippingInvoiced = baseShippingInvoiced;
        }

        public String getBaseShippingAmount() {
            return baseShippingAmount;
        }

        public void setBaseShippingAmount(String baseShippingAmount) {
            this.baseShippingAmount = baseShippingAmount;
        }

        public String getBaseGrandTotal() {
            return baseGrandTotal;
        }

        public void setBaseGrandTotal(String baseGrandTotal) {
            this.baseGrandTotal = baseGrandTotal;
        }

        public String getBaseDiscountInvoiced() {
            return baseDiscountInvoiced;
        }

        public void setBaseDiscountInvoiced(String baseDiscountInvoiced) {
            this.baseDiscountInvoiced = baseDiscountInvoiced;
        }

        public String getBaseDiscountAmount() {
            return baseDiscountAmount;
        }

        public void setBaseDiscountAmount(String baseDiscountAmount) {
            this.baseDiscountAmount = baseDiscountAmount;
        }

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getStoreId() {
            return storeId;
        }

        public void setStoreId(String storeId) {
            this.storeId = storeId;
        }

        public String getIsVirtual() {
            return isVirtual;
        }

        public void setIsVirtual(String isVirtual) {
            this.isVirtual = isVirtual;
        }

        public String getShippingDescription() {
            return shippingDescription;
        }

        public void setShippingDescription(String shippingDescription) {
            this.shippingDescription = shippingDescription;
        }

        public String getProtectCode() {
            return protectCode;
        }

        public void setProtectCode(String protectCode) {
            this.protectCode = protectCode;
        }

        public String getCouponCode() {
            return couponCode;
        }

        public void setCouponCode(String couponCode) {
            this.couponCode = couponCode;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getEntityId() {
            return entityId;
        }

        public void setEntityId(String entityId) {
            this.entityId = entityId;
        }
    }
}
