package com.demo.springboot.helloworld.common.domain;

import java.util.ArrayList;
import java.util.List;

public class HotelExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HotelExample() {
        oredCriteria = new ArrayList<>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andHotelIdIsNull() {
            addCriterion("hotel_id is null");
            return (Criteria) this;
        }

        public Criteria andHotelIdIsNotNull() {
            addCriterion("hotel_id is not null");
            return (Criteria) this;
        }

        public Criteria andHotelIdEqualTo(Integer value) {
            addCriterion("hotel_id =", value, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdNotEqualTo(Integer value) {
            addCriterion("hotel_id <>", value, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdGreaterThan(Integer value) {
            addCriterion("hotel_id >", value, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("hotel_id >=", value, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdLessThan(Integer value) {
            addCriterion("hotel_id <", value, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdLessThanOrEqualTo(Integer value) {
            addCriterion("hotel_id <=", value, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdIn(List<Integer> values) {
            addCriterion("hotel_id in", values, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdNotIn(List<Integer> values) {
            addCriterion("hotel_id not in", values, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdBetween(Integer value1, Integer value2) {
            addCriterion("hotel_id between", value1, value2, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdNotBetween(Integer value1, Integer value2) {
            addCriterion("hotel_id not between", value1, value2, "hotelId");
            return (Criteria) this;
        }

        public Criteria andChainIdIsNull() {
            addCriterion("chain_id is null");
            return (Criteria) this;
        }

        public Criteria andChainIdIsNotNull() {
            addCriterion("chain_id is not null");
            return (Criteria) this;
        }

        public Criteria andChainIdEqualTo(Integer value) {
            addCriterion("chain_id =", value, "chainId");
            return (Criteria) this;
        }

        public Criteria andChainIdNotEqualTo(Integer value) {
            addCriterion("chain_id <>", value, "chainId");
            return (Criteria) this;
        }

        public Criteria andChainIdGreaterThan(Integer value) {
            addCriterion("chain_id >", value, "chainId");
            return (Criteria) this;
        }

        public Criteria andChainIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("chain_id >=", value, "chainId");
            return (Criteria) this;
        }

        public Criteria andChainIdLessThan(Integer value) {
            addCriterion("chain_id <", value, "chainId");
            return (Criteria) this;
        }

        public Criteria andChainIdLessThanOrEqualTo(Integer value) {
            addCriterion("chain_id <=", value, "chainId");
            return (Criteria) this;
        }

        public Criteria andChainIdIn(List<Integer> values) {
            addCriterion("chain_id in", values, "chainId");
            return (Criteria) this;
        }

        public Criteria andChainIdNotIn(List<Integer> values) {
            addCriterion("chain_id not in", values, "chainId");
            return (Criteria) this;
        }

        public Criteria andChainIdBetween(Integer value1, Integer value2) {
            addCriterion("chain_id between", value1, value2, "chainId");
            return (Criteria) this;
        }

        public Criteria andChainIdNotBetween(Integer value1, Integer value2) {
            addCriterion("chain_id not between", value1, value2, "chainId");
            return (Criteria) this;
        }

        public Criteria andChainNameIsNull() {
            addCriterion("chain_name is null");
            return (Criteria) this;
        }

        public Criteria andChainNameIsNotNull() {
            addCriterion("chain_name is not null");
            return (Criteria) this;
        }

        public Criteria andChainNameEqualTo(String value) {
            addCriterion("chain_name =", value, "chainName");
            return (Criteria) this;
        }

        public Criteria andChainNameNotEqualTo(String value) {
            addCriterion("chain_name <>", value, "chainName");
            return (Criteria) this;
        }

        public Criteria andChainNameGreaterThan(String value) {
            addCriterion("chain_name >", value, "chainName");
            return (Criteria) this;
        }

        public Criteria andChainNameGreaterThanOrEqualTo(String value) {
            addCriterion("chain_name >=", value, "chainName");
            return (Criteria) this;
        }

        public Criteria andChainNameLessThan(String value) {
            addCriterion("chain_name <", value, "chainName");
            return (Criteria) this;
        }

        public Criteria andChainNameLessThanOrEqualTo(String value) {
            addCriterion("chain_name <=", value, "chainName");
            return (Criteria) this;
        }

        public Criteria andChainNameLike(String value) {
            addCriterion("chain_name like", value, "chainName");
            return (Criteria) this;
        }

        public Criteria andChainNameNotLike(String value) {
            addCriterion("chain_name not like", value, "chainName");
            return (Criteria) this;
        }

        public Criteria andChainNameIn(List<String> values) {
            addCriterion("chain_name in", values, "chainName");
            return (Criteria) this;
        }

        public Criteria andChainNameNotIn(List<String> values) {
            addCriterion("chain_name not in", values, "chainName");
            return (Criteria) this;
        }

        public Criteria andChainNameBetween(String value1, String value2) {
            addCriterion("chain_name between", value1, value2, "chainName");
            return (Criteria) this;
        }

        public Criteria andChainNameNotBetween(String value1, String value2) {
            addCriterion("chain_name not between", value1, value2, "chainName");
            return (Criteria) this;
        }

        public Criteria andBrandIdIsNull() {
            addCriterion("brand_id is null");
            return (Criteria) this;
        }

        public Criteria andBrandIdIsNotNull() {
            addCriterion("brand_id is not null");
            return (Criteria) this;
        }

        public Criteria andBrandIdEqualTo(Integer value) {
            addCriterion("brand_id =", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdNotEqualTo(Integer value) {
            addCriterion("brand_id <>", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdGreaterThan(Integer value) {
            addCriterion("brand_id >", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("brand_id >=", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdLessThan(Integer value) {
            addCriterion("brand_id <", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdLessThanOrEqualTo(Integer value) {
            addCriterion("brand_id <=", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdIn(List<Integer> values) {
            addCriterion("brand_id in", values, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdNotIn(List<Integer> values) {
            addCriterion("brand_id not in", values, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdBetween(Integer value1, Integer value2) {
            addCriterion("brand_id between", value1, value2, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdNotBetween(Integer value1, Integer value2) {
            addCriterion("brand_id not between", value1, value2, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandNameIsNull() {
            addCriterion("brand_name is null");
            return (Criteria) this;
        }

        public Criteria andBrandNameIsNotNull() {
            addCriterion("brand_name is not null");
            return (Criteria) this;
        }

        public Criteria andBrandNameEqualTo(String value) {
            addCriterion("brand_name =", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameNotEqualTo(String value) {
            addCriterion("brand_name <>", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameGreaterThan(String value) {
            addCriterion("brand_name >", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameGreaterThanOrEqualTo(String value) {
            addCriterion("brand_name >=", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameLessThan(String value) {
            addCriterion("brand_name <", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameLessThanOrEqualTo(String value) {
            addCriterion("brand_name <=", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameLike(String value) {
            addCriterion("brand_name like", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameNotLike(String value) {
            addCriterion("brand_name not like", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameIn(List<String> values) {
            addCriterion("brand_name in", values, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameNotIn(List<String> values) {
            addCriterion("brand_name not in", values, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameBetween(String value1, String value2) {
            addCriterion("brand_name between", value1, value2, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameNotBetween(String value1, String value2) {
            addCriterion("brand_name not between", value1, value2, "brandName");
            return (Criteria) this;
        }

        public Criteria andHotelNameIsNull() {
            addCriterion("hotel_name is null");
            return (Criteria) this;
        }

        public Criteria andHotelNameIsNotNull() {
            addCriterion("hotel_name is not null");
            return (Criteria) this;
        }

        public Criteria andHotelNameEqualTo(String value) {
            addCriterion("hotel_name =", value, "hotelName");
            return (Criteria) this;
        }

        public Criteria andHotelNameNotEqualTo(String value) {
            addCriterion("hotel_name <>", value, "hotelName");
            return (Criteria) this;
        }

        public Criteria andHotelNameGreaterThan(String value) {
            addCriterion("hotel_name >", value, "hotelName");
            return (Criteria) this;
        }

        public Criteria andHotelNameGreaterThanOrEqualTo(String value) {
            addCriterion("hotel_name >=", value, "hotelName");
            return (Criteria) this;
        }

        public Criteria andHotelNameLessThan(String value) {
            addCriterion("hotel_name <", value, "hotelName");
            return (Criteria) this;
        }

        public Criteria andHotelNameLessThanOrEqualTo(String value) {
            addCriterion("hotel_name <=", value, "hotelName");
            return (Criteria) this;
        }

        public Criteria andHotelNameLike(String value) {
            addCriterion("hotel_name like", value, "hotelName");
            return (Criteria) this;
        }

        public Criteria andHotelNameNotLike(String value) {
            addCriterion("hotel_name not like", value, "hotelName");
            return (Criteria) this;
        }

        public Criteria andHotelNameIn(List<String> values) {
            addCriterion("hotel_name in", values, "hotelName");
            return (Criteria) this;
        }

        public Criteria andHotelNameNotIn(List<String> values) {
            addCriterion("hotel_name not in", values, "hotelName");
            return (Criteria) this;
        }

        public Criteria andHotelNameBetween(String value1, String value2) {
            addCriterion("hotel_name between", value1, value2, "hotelName");
            return (Criteria) this;
        }

        public Criteria andHotelNameNotBetween(String value1, String value2) {
            addCriterion("hotel_name not between", value1, value2, "hotelName");
            return (Criteria) this;
        }

        public Criteria andHotelFormerlyNameIsNull() {
            addCriterion("hotel_formerly_name is null");
            return (Criteria) this;
        }

        public Criteria andHotelFormerlyNameIsNotNull() {
            addCriterion("hotel_formerly_name is not null");
            return (Criteria) this;
        }

        public Criteria andHotelFormerlyNameEqualTo(String value) {
            addCriterion("hotel_formerly_name =", value, "hotelFormerlyName");
            return (Criteria) this;
        }

        public Criteria andHotelFormerlyNameNotEqualTo(String value) {
            addCriterion("hotel_formerly_name <>", value, "hotelFormerlyName");
            return (Criteria) this;
        }

        public Criteria andHotelFormerlyNameGreaterThan(String value) {
            addCriterion("hotel_formerly_name >", value, "hotelFormerlyName");
            return (Criteria) this;
        }

        public Criteria andHotelFormerlyNameGreaterThanOrEqualTo(String value) {
            addCriterion("hotel_formerly_name >=", value, "hotelFormerlyName");
            return (Criteria) this;
        }

        public Criteria andHotelFormerlyNameLessThan(String value) {
            addCriterion("hotel_formerly_name <", value, "hotelFormerlyName");
            return (Criteria) this;
        }

        public Criteria andHotelFormerlyNameLessThanOrEqualTo(String value) {
            addCriterion("hotel_formerly_name <=", value, "hotelFormerlyName");
            return (Criteria) this;
        }

        public Criteria andHotelFormerlyNameLike(String value) {
            addCriterion("hotel_formerly_name like", value, "hotelFormerlyName");
            return (Criteria) this;
        }

        public Criteria andHotelFormerlyNameNotLike(String value) {
            addCriterion("hotel_formerly_name not like", value, "hotelFormerlyName");
            return (Criteria) this;
        }

        public Criteria andHotelFormerlyNameIn(List<String> values) {
            addCriterion("hotel_formerly_name in", values, "hotelFormerlyName");
            return (Criteria) this;
        }

        public Criteria andHotelFormerlyNameNotIn(List<String> values) {
            addCriterion("hotel_formerly_name not in", values, "hotelFormerlyName");
            return (Criteria) this;
        }

        public Criteria andHotelFormerlyNameBetween(String value1, String value2) {
            addCriterion("hotel_formerly_name between", value1, value2, "hotelFormerlyName");
            return (Criteria) this;
        }

        public Criteria andHotelFormerlyNameNotBetween(String value1, String value2) {
            addCriterion("hotel_formerly_name not between", value1, value2, "hotelFormerlyName");
            return (Criteria) this;
        }

        public Criteria andHotelTranslatedNameIsNull() {
            addCriterion("hotel_translated_name is null");
            return (Criteria) this;
        }

        public Criteria andHotelTranslatedNameIsNotNull() {
            addCriterion("hotel_translated_name is not null");
            return (Criteria) this;
        }

        public Criteria andHotelTranslatedNameEqualTo(String value) {
            addCriterion("hotel_translated_name =", value, "hotelTranslatedName");
            return (Criteria) this;
        }

        public Criteria andHotelTranslatedNameNotEqualTo(String value) {
            addCriterion("hotel_translated_name <>", value, "hotelTranslatedName");
            return (Criteria) this;
        }

        public Criteria andHotelTranslatedNameGreaterThan(String value) {
            addCriterion("hotel_translated_name >", value, "hotelTranslatedName");
            return (Criteria) this;
        }

        public Criteria andHotelTranslatedNameGreaterThanOrEqualTo(String value) {
            addCriterion("hotel_translated_name >=", value, "hotelTranslatedName");
            return (Criteria) this;
        }

        public Criteria andHotelTranslatedNameLessThan(String value) {
            addCriterion("hotel_translated_name <", value, "hotelTranslatedName");
            return (Criteria) this;
        }

        public Criteria andHotelTranslatedNameLessThanOrEqualTo(String value) {
            addCriterion("hotel_translated_name <=", value, "hotelTranslatedName");
            return (Criteria) this;
        }

        public Criteria andHotelTranslatedNameLike(String value) {
            addCriterion("hotel_translated_name like", value, "hotelTranslatedName");
            return (Criteria) this;
        }

        public Criteria andHotelTranslatedNameNotLike(String value) {
            addCriterion("hotel_translated_name not like", value, "hotelTranslatedName");
            return (Criteria) this;
        }

        public Criteria andHotelTranslatedNameIn(List<String> values) {
            addCriterion("hotel_translated_name in", values, "hotelTranslatedName");
            return (Criteria) this;
        }

        public Criteria andHotelTranslatedNameNotIn(List<String> values) {
            addCriterion("hotel_translated_name not in", values, "hotelTranslatedName");
            return (Criteria) this;
        }

        public Criteria andHotelTranslatedNameBetween(String value1, String value2) {
            addCriterion("hotel_translated_name between", value1, value2, "hotelTranslatedName");
            return (Criteria) this;
        }

        public Criteria andHotelTranslatedNameNotBetween(String value1, String value2) {
            addCriterion("hotel_translated_name not between", value1, value2, "hotelTranslatedName");
            return (Criteria) this;
        }

        public Criteria andAddressLine1IsNull() {
            addCriterion("address_line1 is null");
            return (Criteria) this;
        }

        public Criteria andAddressLine1IsNotNull() {
            addCriterion("address_line1 is not null");
            return (Criteria) this;
        }

        public Criteria andAddressLine1EqualTo(String value) {
            addCriterion("address_line1 =", value, "addressLine1");
            return (Criteria) this;
        }

        public Criteria andAddressLine1NotEqualTo(String value) {
            addCriterion("address_line1 <>", value, "addressLine1");
            return (Criteria) this;
        }

        public Criteria andAddressLine1GreaterThan(String value) {
            addCriterion("address_line1 >", value, "addressLine1");
            return (Criteria) this;
        }

        public Criteria andAddressLine1GreaterThanOrEqualTo(String value) {
            addCriterion("address_line1 >=", value, "addressLine1");
            return (Criteria) this;
        }

        public Criteria andAddressLine1LessThan(String value) {
            addCriterion("address_line1 <", value, "addressLine1");
            return (Criteria) this;
        }

        public Criteria andAddressLine1LessThanOrEqualTo(String value) {
            addCriterion("address_line1 <=", value, "addressLine1");
            return (Criteria) this;
        }

        public Criteria andAddressLine1Like(String value) {
            addCriterion("address_line1 like", value, "addressLine1");
            return (Criteria) this;
        }

        public Criteria andAddressLine1NotLike(String value) {
            addCriterion("address_line1 not like", value, "addressLine1");
            return (Criteria) this;
        }

        public Criteria andAddressLine1In(List<String> values) {
            addCriterion("address_line1 in", values, "addressLine1");
            return (Criteria) this;
        }

        public Criteria andAddressLine1NotIn(List<String> values) {
            addCriterion("address_line1 not in", values, "addressLine1");
            return (Criteria) this;
        }

        public Criteria andAddressLine1Between(String value1, String value2) {
            addCriterion("address_line1 between", value1, value2, "addressLine1");
            return (Criteria) this;
        }

        public Criteria andAddressLine1NotBetween(String value1, String value2) {
            addCriterion("address_line1 not between", value1, value2, "addressLine1");
            return (Criteria) this;
        }

        public Criteria andAddressLine2IsNull() {
            addCriterion("address_line2 is null");
            return (Criteria) this;
        }

        public Criteria andAddressLine2IsNotNull() {
            addCriterion("address_line2 is not null");
            return (Criteria) this;
        }

        public Criteria andAddressLine2EqualTo(String value) {
            addCriterion("address_line2 =", value, "addressLine2");
            return (Criteria) this;
        }

        public Criteria andAddressLine2NotEqualTo(String value) {
            addCriterion("address_line2 <>", value, "addressLine2");
            return (Criteria) this;
        }

        public Criteria andAddressLine2GreaterThan(String value) {
            addCriterion("address_line2 >", value, "addressLine2");
            return (Criteria) this;
        }

        public Criteria andAddressLine2GreaterThanOrEqualTo(String value) {
            addCriterion("address_line2 >=", value, "addressLine2");
            return (Criteria) this;
        }

        public Criteria andAddressLine2LessThan(String value) {
            addCriterion("address_line2 <", value, "addressLine2");
            return (Criteria) this;
        }

        public Criteria andAddressLine2LessThanOrEqualTo(String value) {
            addCriterion("address_line2 <=", value, "addressLine2");
            return (Criteria) this;
        }

        public Criteria andAddressLine2Like(String value) {
            addCriterion("address_line2 like", value, "addressLine2");
            return (Criteria) this;
        }

        public Criteria andAddressLine2NotLike(String value) {
            addCriterion("address_line2 not like", value, "addressLine2");
            return (Criteria) this;
        }

        public Criteria andAddressLine2In(List<String> values) {
            addCriterion("address_line2 in", values, "addressLine2");
            return (Criteria) this;
        }

        public Criteria andAddressLine2NotIn(List<String> values) {
            addCriterion("address_line2 not in", values, "addressLine2");
            return (Criteria) this;
        }

        public Criteria andAddressLine2Between(String value1, String value2) {
            addCriterion("address_line2 between", value1, value2, "addressLine2");
            return (Criteria) this;
        }

        public Criteria andAddressLine2NotBetween(String value1, String value2) {
            addCriterion("address_line2 not between", value1, value2, "addressLine2");
            return (Criteria) this;
        }

        public Criteria andZipcodeIsNull() {
            addCriterion("zipcode is null");
            return (Criteria) this;
        }

        public Criteria andZipcodeIsNotNull() {
            addCriterion("zipcode is not null");
            return (Criteria) this;
        }

        public Criteria andZipcodeEqualTo(Integer value) {
            addCriterion("zipcode =", value, "zipcode");
            return (Criteria) this;
        }

        public Criteria andZipcodeNotEqualTo(Integer value) {
            addCriterion("zipcode <>", value, "zipcode");
            return (Criteria) this;
        }

        public Criteria andZipcodeGreaterThan(Integer value) {
            addCriterion("zipcode >", value, "zipcode");
            return (Criteria) this;
        }

        public Criteria andZipcodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("zipcode >=", value, "zipcode");
            return (Criteria) this;
        }

        public Criteria andZipcodeLessThan(Integer value) {
            addCriterion("zipcode <", value, "zipcode");
            return (Criteria) this;
        }

        public Criteria andZipcodeLessThanOrEqualTo(Integer value) {
            addCriterion("zipcode <=", value, "zipcode");
            return (Criteria) this;
        }

        public Criteria andZipcodeIn(List<Integer> values) {
            addCriterion("zipcode in", values, "zipcode");
            return (Criteria) this;
        }

        public Criteria andZipcodeNotIn(List<Integer> values) {
            addCriterion("zipcode not in", values, "zipcode");
            return (Criteria) this;
        }

        public Criteria andZipcodeBetween(Integer value1, Integer value2) {
            addCriterion("zipcode between", value1, value2, "zipcode");
            return (Criteria) this;
        }

        public Criteria andZipcodeNotBetween(Integer value1, Integer value2) {
            addCriterion("zipcode not between", value1, value2, "zipcode");
            return (Criteria) this;
        }

        public Criteria andCityIsNull() {
            addCriterion("city is null");
            return (Criteria) this;
        }

        public Criteria andCityIsNotNull() {
            addCriterion("city is not null");
            return (Criteria) this;
        }

        public Criteria andCityEqualTo(String value) {
            addCriterion("city =", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotEqualTo(String value) {
            addCriterion("city <>", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThan(String value) {
            addCriterion("city >", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThanOrEqualTo(String value) {
            addCriterion("city >=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThan(String value) {
            addCriterion("city <", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThanOrEqualTo(String value) {
            addCriterion("city <=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLike(String value) {
            addCriterion("city like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotLike(String value) {
            addCriterion("city not like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityIn(List<String> values) {
            addCriterion("city in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotIn(List<String> values) {
            addCriterion("city not in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityBetween(String value1, String value2) {
            addCriterion("city between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotBetween(String value1, String value2) {
            addCriterion("city not between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andState1IsNull() {
            addCriterion("state1 is null");
            return (Criteria) this;
        }

        public Criteria andState1IsNotNull() {
            addCriterion("state1 is not null");
            return (Criteria) this;
        }

        public Criteria andState1EqualTo(String value) {
            addCriterion("state1 =", value, "state1");
            return (Criteria) this;
        }

        public Criteria andState1NotEqualTo(String value) {
            addCriterion("state1 <>", value, "state1");
            return (Criteria) this;
        }

        public Criteria andState1GreaterThan(String value) {
            addCriterion("state1 >", value, "state1");
            return (Criteria) this;
        }

        public Criteria andState1GreaterThanOrEqualTo(String value) {
            addCriterion("state1 >=", value, "state1");
            return (Criteria) this;
        }

        public Criteria andState1LessThan(String value) {
            addCriterion("state1 <", value, "state1");
            return (Criteria) this;
        }

        public Criteria andState1LessThanOrEqualTo(String value) {
            addCriterion("state1 <=", value, "state1");
            return (Criteria) this;
        }

        public Criteria andState1Like(String value) {
            addCriterion("state1 like", value, "state1");
            return (Criteria) this;
        }

        public Criteria andState1NotLike(String value) {
            addCriterion("state1 not like", value, "state1");
            return (Criteria) this;
        }

        public Criteria andState1In(List<String> values) {
            addCriterion("state1 in", values, "state1");
            return (Criteria) this;
        }

        public Criteria andState1NotIn(List<String> values) {
            addCriterion("state1 not in", values, "state1");
            return (Criteria) this;
        }

        public Criteria andState1Between(String value1, String value2) {
            addCriterion("state1 between", value1, value2, "state1");
            return (Criteria) this;
        }

        public Criteria andState1NotBetween(String value1, String value2) {
            addCriterion("state1 not between", value1, value2, "state1");
            return (Criteria) this;
        }

        public Criteria andCountryIsNull() {
            addCriterion("country is null");
            return (Criteria) this;
        }

        public Criteria andCountryIsNotNull() {
            addCriterion("country is not null");
            return (Criteria) this;
        }

        public Criteria andCountryEqualTo(String value) {
            addCriterion("country =", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotEqualTo(String value) {
            addCriterion("country <>", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryGreaterThan(String value) {
            addCriterion("country >", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryGreaterThanOrEqualTo(String value) {
            addCriterion("country >=", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryLessThan(String value) {
            addCriterion("country <", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryLessThanOrEqualTo(String value) {
            addCriterion("country <=", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryLike(String value) {
            addCriterion("country like", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotLike(String value) {
            addCriterion("country not like", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryIn(List<String> values) {
            addCriterion("country in", values, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotIn(List<String> values) {
            addCriterion("country not in", values, "country");
            return (Criteria) this;
        }

        public Criteria andCountryBetween(String value1, String value2) {
            addCriterion("country between", value1, value2, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotBetween(String value1, String value2) {
            addCriterion("country not between", value1, value2, "country");
            return (Criteria) this;
        }

        public Criteria andCountryIsoCodeIsNull() {
            addCriterion("country_iso_code is null");
            return (Criteria) this;
        }

        public Criteria andCountryIsoCodeIsNotNull() {
            addCriterion("country_iso_code is not null");
            return (Criteria) this;
        }

        public Criteria andCountryIsoCodeEqualTo(String value) {
            addCriterion("country_iso_code =", value, "countryIsoCode");
            return (Criteria) this;
        }

        public Criteria andCountryIsoCodeNotEqualTo(String value) {
            addCriterion("country_iso_code <>", value, "countryIsoCode");
            return (Criteria) this;
        }

        public Criteria andCountryIsoCodeGreaterThan(String value) {
            addCriterion("country_iso_code >", value, "countryIsoCode");
            return (Criteria) this;
        }

        public Criteria andCountryIsoCodeGreaterThanOrEqualTo(String value) {
            addCriterion("country_iso_code >=", value, "countryIsoCode");
            return (Criteria) this;
        }

        public Criteria andCountryIsoCodeLessThan(String value) {
            addCriterion("country_iso_code <", value, "countryIsoCode");
            return (Criteria) this;
        }

        public Criteria andCountryIsoCodeLessThanOrEqualTo(String value) {
            addCriterion("country_iso_code <=", value, "countryIsoCode");
            return (Criteria) this;
        }

        public Criteria andCountryIsoCodeLike(String value) {
            addCriterion("country_iso_code like", value, "countryIsoCode");
            return (Criteria) this;
        }

        public Criteria andCountryIsoCodeNotLike(String value) {
            addCriterion("country_iso_code not like", value, "countryIsoCode");
            return (Criteria) this;
        }

        public Criteria andCountryIsoCodeIn(List<String> values) {
            addCriterion("country_iso_code in", values, "countryIsoCode");
            return (Criteria) this;
        }

        public Criteria andCountryIsoCodeNotIn(List<String> values) {
            addCriterion("country_iso_code not in", values, "countryIsoCode");
            return (Criteria) this;
        }

        public Criteria andCountryIsoCodeBetween(String value1, String value2) {
            addCriterion("country_iso_code between", value1, value2, "countryIsoCode");
            return (Criteria) this;
        }

        public Criteria andCountryIsoCodeNotBetween(String value1, String value2) {
            addCriterion("country_iso_code not between", value1, value2, "countryIsoCode");
            return (Criteria) this;
        }

        public Criteria andStarRatingIsNull() {
            addCriterion("star_rating is null");
            return (Criteria) this;
        }

        public Criteria andStarRatingIsNotNull() {
            addCriterion("star_rating is not null");
            return (Criteria) this;
        }

        public Criteria andStarRatingEqualTo(Integer value) {
            addCriterion("star_rating =", value, "starRating");
            return (Criteria) this;
        }

        public Criteria andStarRatingNotEqualTo(Integer value) {
            addCriterion("star_rating <>", value, "starRating");
            return (Criteria) this;
        }

        public Criteria andStarRatingGreaterThan(Integer value) {
            addCriterion("star_rating >", value, "starRating");
            return (Criteria) this;
        }

        public Criteria andStarRatingGreaterThanOrEqualTo(Integer value) {
            addCriterion("star_rating >=", value, "starRating");
            return (Criteria) this;
        }

        public Criteria andStarRatingLessThan(Integer value) {
            addCriterion("star_rating <", value, "starRating");
            return (Criteria) this;
        }

        public Criteria andStarRatingLessThanOrEqualTo(Integer value) {
            addCriterion("star_rating <=", value, "starRating");
            return (Criteria) this;
        }

        public Criteria andStarRatingIn(List<Integer> values) {
            addCriterion("star_rating in", values, "starRating");
            return (Criteria) this;
        }

        public Criteria andStarRatingNotIn(List<Integer> values) {
            addCriterion("star_rating not in", values, "starRating");
            return (Criteria) this;
        }

        public Criteria andStarRatingBetween(Integer value1, Integer value2) {
            addCriterion("star_rating between", value1, value2, "starRating");
            return (Criteria) this;
        }

        public Criteria andStarRatingNotBetween(Integer value1, Integer value2) {
            addCriterion("star_rating not between", value1, value2, "starRating");
            return (Criteria) this;
        }

        public Criteria andLongtitudeIsNull() {
            addCriterion("longtitude is null");
            return (Criteria) this;
        }

        public Criteria andLongtitudeIsNotNull() {
            addCriterion("longtitude is not null");
            return (Criteria) this;
        }

        public Criteria andLongtitudeEqualTo(Double value) {
            addCriterion("longtitude =", value, "longtitude");
            return (Criteria) this;
        }

        public Criteria andLongtitudeNotEqualTo(Double value) {
            addCriterion("longtitude <>", value, "longtitude");
            return (Criteria) this;
        }

        public Criteria andLongtitudeGreaterThan(Double value) {
            addCriterion("longtitude >", value, "longtitude");
            return (Criteria) this;
        }

        public Criteria andLongtitudeGreaterThanOrEqualTo(Double value) {
            addCriterion("longtitude >=", value, "longtitude");
            return (Criteria) this;
        }

        public Criteria andLongtitudeLessThan(Double value) {
            addCriterion("longtitude <", value, "longtitude");
            return (Criteria) this;
        }

        public Criteria andLongtitudeLessThanOrEqualTo(Double value) {
            addCriterion("longtitude <=", value, "longtitude");
            return (Criteria) this;
        }

        public Criteria andLongtitudeIn(List<Double> values) {
            addCriterion("longtitude in", values, "longtitude");
            return (Criteria) this;
        }

        public Criteria andLongtitudeNotIn(List<Double> values) {
            addCriterion("longtitude not in", values, "longtitude");
            return (Criteria) this;
        }

        public Criteria andLongtitudeBetween(Double value1, Double value2) {
            addCriterion("longtitude between", value1, value2, "longtitude");
            return (Criteria) this;
        }

        public Criteria andLongtitudeNotBetween(Double value1, Double value2) {
            addCriterion("longtitude not between", value1, value2, "longtitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeIsNull() {
            addCriterion("latitude is null");
            return (Criteria) this;
        }

        public Criteria andLatitudeIsNotNull() {
            addCriterion("latitude is not null");
            return (Criteria) this;
        }

        public Criteria andLatitudeEqualTo(Double value) {
            addCriterion("latitude =", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotEqualTo(Double value) {
            addCriterion("latitude <>", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThan(Double value) {
            addCriterion("latitude >", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThanOrEqualTo(Double value) {
            addCriterion("latitude >=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThan(Double value) {
            addCriterion("latitude <", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThanOrEqualTo(Double value) {
            addCriterion("latitude <=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeIn(List<Double> values) {
            addCriterion("latitude in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotIn(List<Double> values) {
            addCriterion("latitude not in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeBetween(Double value1, Double value2) {
            addCriterion("latitude between", value1, value2, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotBetween(Double value1, Double value2) {
            addCriterion("latitude not between", value1, value2, "latitude");
            return (Criteria) this;
        }

        public Criteria andUrl1IsNull() {
            addCriterion("url1 is null");
            return (Criteria) this;
        }

        public Criteria andUrl1IsNotNull() {
            addCriterion("url1 is not null");
            return (Criteria) this;
        }

        public Criteria andUrl1EqualTo(String value) {
            addCriterion("url1 =", value, "url1");
            return (Criteria) this;
        }

        public Criteria andUrl1NotEqualTo(String value) {
            addCriterion("url1 <>", value, "url1");
            return (Criteria) this;
        }

        public Criteria andUrl1GreaterThan(String value) {
            addCriterion("url1 >", value, "url1");
            return (Criteria) this;
        }

        public Criteria andUrl1GreaterThanOrEqualTo(String value) {
            addCriterion("url1 >=", value, "url1");
            return (Criteria) this;
        }

        public Criteria andUrl1LessThan(String value) {
            addCriterion("url1 <", value, "url1");
            return (Criteria) this;
        }

        public Criteria andUrl1LessThanOrEqualTo(String value) {
            addCriterion("url1 <=", value, "url1");
            return (Criteria) this;
        }

        public Criteria andUrl1Like(String value) {
            addCriterion("url1 like", value, "url1");
            return (Criteria) this;
        }

        public Criteria andUrl1NotLike(String value) {
            addCriterion("url1 not like", value, "url1");
            return (Criteria) this;
        }

        public Criteria andUrl1In(List<String> values) {
            addCriterion("url1 in", values, "url1");
            return (Criteria) this;
        }

        public Criteria andUrl1NotIn(List<String> values) {
            addCriterion("url1 not in", values, "url1");
            return (Criteria) this;
        }

        public Criteria andUrl1Between(String value1, String value2) {
            addCriterion("url1 between", value1, value2, "url1");
            return (Criteria) this;
        }

        public Criteria andUrl1NotBetween(String value1, String value2) {
            addCriterion("url1 not between", value1, value2, "url1");
            return (Criteria) this;
        }

        public Criteria andCheckInIsNull() {
            addCriterion("check_in is null");
            return (Criteria) this;
        }

        public Criteria andCheckInIsNotNull() {
            addCriterion("check_in is not null");
            return (Criteria) this;
        }

        public Criteria andCheckInEqualTo(String value) {
            addCriterion("check_in =", value, "checkIn");
            return (Criteria) this;
        }

        public Criteria andCheckInNotEqualTo(String value) {
            addCriterion("check_in <>", value, "checkIn");
            return (Criteria) this;
        }

        public Criteria andCheckInGreaterThan(String value) {
            addCriterion("check_in >", value, "checkIn");
            return (Criteria) this;
        }

        public Criteria andCheckInGreaterThanOrEqualTo(String value) {
            addCriterion("check_in >=", value, "checkIn");
            return (Criteria) this;
        }

        public Criteria andCheckInLessThan(String value) {
            addCriterion("check_in <", value, "checkIn");
            return (Criteria) this;
        }

        public Criteria andCheckInLessThanOrEqualTo(String value) {
            addCriterion("check_in <=", value, "checkIn");
            return (Criteria) this;
        }

        public Criteria andCheckInLike(String value) {
            addCriterion("check_in like", value, "checkIn");
            return (Criteria) this;
        }

        public Criteria andCheckInNotLike(String value) {
            addCriterion("check_in not like", value, "checkIn");
            return (Criteria) this;
        }

        public Criteria andCheckInIn(List<String> values) {
            addCriterion("check_in in", values, "checkIn");
            return (Criteria) this;
        }

        public Criteria andCheckInNotIn(List<String> values) {
            addCriterion("check_in not in", values, "checkIn");
            return (Criteria) this;
        }

        public Criteria andCheckInBetween(String value1, String value2) {
            addCriterion("check_in between", value1, value2, "checkIn");
            return (Criteria) this;
        }

        public Criteria andCheckInNotBetween(String value1, String value2) {
            addCriterion("check_in not between", value1, value2, "checkIn");
            return (Criteria) this;
        }

        public Criteria andCheckOutIsNull() {
            addCriterion("check_out is null");
            return (Criteria) this;
        }

        public Criteria andCheckOutIsNotNull() {
            addCriterion("check_out is not null");
            return (Criteria) this;
        }

        public Criteria andCheckOutEqualTo(String value) {
            addCriterion("check_out =", value, "checkOut");
            return (Criteria) this;
        }

        public Criteria andCheckOutNotEqualTo(String value) {
            addCriterion("check_out <>", value, "checkOut");
            return (Criteria) this;
        }

        public Criteria andCheckOutGreaterThan(String value) {
            addCriterion("check_out >", value, "checkOut");
            return (Criteria) this;
        }

        public Criteria andCheckOutGreaterThanOrEqualTo(String value) {
            addCriterion("check_out >=", value, "checkOut");
            return (Criteria) this;
        }

        public Criteria andCheckOutLessThan(String value) {
            addCriterion("check_out <", value, "checkOut");
            return (Criteria) this;
        }

        public Criteria andCheckOutLessThanOrEqualTo(String value) {
            addCriterion("check_out <=", value, "checkOut");
            return (Criteria) this;
        }

        public Criteria andCheckOutLike(String value) {
            addCriterion("check_out like", value, "checkOut");
            return (Criteria) this;
        }

        public Criteria andCheckOutNotLike(String value) {
            addCriterion("check_out not like", value, "checkOut");
            return (Criteria) this;
        }

        public Criteria andCheckOutIn(List<String> values) {
            addCriterion("check_out in", values, "checkOut");
            return (Criteria) this;
        }

        public Criteria andCheckOutNotIn(List<String> values) {
            addCriterion("check_out not in", values, "checkOut");
            return (Criteria) this;
        }

        public Criteria andCheckOutBetween(String value1, String value2) {
            addCriterion("check_out between", value1, value2, "checkOut");
            return (Criteria) this;
        }

        public Criteria andCheckOutNotBetween(String value1, String value2) {
            addCriterion("check_out not between", value1, value2, "checkOut");
            return (Criteria) this;
        }

        public Criteria andNumberRoomsIsNull() {
            addCriterion("number_rooms is null");
            return (Criteria) this;
        }

        public Criteria andNumberRoomsIsNotNull() {
            addCriterion("number_rooms is not null");
            return (Criteria) this;
        }

        public Criteria andNumberRoomsEqualTo(Integer value) {
            addCriterion("number_rooms =", value, "numberRooms");
            return (Criteria) this;
        }

        public Criteria andNumberRoomsNotEqualTo(Integer value) {
            addCriterion("number_rooms <>", value, "numberRooms");
            return (Criteria) this;
        }

        public Criteria andNumberRoomsGreaterThan(Integer value) {
            addCriterion("number_rooms >", value, "numberRooms");
            return (Criteria) this;
        }

        public Criteria andNumberRoomsGreaterThanOrEqualTo(Integer value) {
            addCriterion("number_rooms >=", value, "numberRooms");
            return (Criteria) this;
        }

        public Criteria andNumberRoomsLessThan(Integer value) {
            addCriterion("number_rooms <", value, "numberRooms");
            return (Criteria) this;
        }

        public Criteria andNumberRoomsLessThanOrEqualTo(Integer value) {
            addCriterion("number_rooms <=", value, "numberRooms");
            return (Criteria) this;
        }

        public Criteria andNumberRoomsIn(List<Integer> values) {
            addCriterion("number_rooms in", values, "numberRooms");
            return (Criteria) this;
        }

        public Criteria andNumberRoomsNotIn(List<Integer> values) {
            addCriterion("number_rooms not in", values, "numberRooms");
            return (Criteria) this;
        }

        public Criteria andNumberRoomsBetween(Integer value1, Integer value2) {
            addCriterion("number_rooms between", value1, value2, "numberRooms");
            return (Criteria) this;
        }

        public Criteria andNumberRoomsNotBetween(Integer value1, Integer value2) {
            addCriterion("number_rooms not between", value1, value2, "numberRooms");
            return (Criteria) this;
        }

        public Criteria andNumberFloorsIsNull() {
            addCriterion("number_floors is null");
            return (Criteria) this;
        }

        public Criteria andNumberFloorsIsNotNull() {
            addCriterion("number_floors is not null");
            return (Criteria) this;
        }

        public Criteria andNumberFloorsEqualTo(Integer value) {
            addCriterion("number_floors =", value, "numberFloors");
            return (Criteria) this;
        }

        public Criteria andNumberFloorsNotEqualTo(Integer value) {
            addCriterion("number_floors <>", value, "numberFloors");
            return (Criteria) this;
        }

        public Criteria andNumberFloorsGreaterThan(Integer value) {
            addCriterion("number_floors >", value, "numberFloors");
            return (Criteria) this;
        }

        public Criteria andNumberFloorsGreaterThanOrEqualTo(Integer value) {
            addCriterion("number_floors >=", value, "numberFloors");
            return (Criteria) this;
        }

        public Criteria andNumberFloorsLessThan(Integer value) {
            addCriterion("number_floors <", value, "numberFloors");
            return (Criteria) this;
        }

        public Criteria andNumberFloorsLessThanOrEqualTo(Integer value) {
            addCriterion("number_floors <=", value, "numberFloors");
            return (Criteria) this;
        }

        public Criteria andNumberFloorsIn(List<Integer> values) {
            addCriterion("number_floors in", values, "numberFloors");
            return (Criteria) this;
        }

        public Criteria andNumberFloorsNotIn(List<Integer> values) {
            addCriterion("number_floors not in", values, "numberFloors");
            return (Criteria) this;
        }

        public Criteria andNumberFloorsBetween(Integer value1, Integer value2) {
            addCriterion("number_floors between", value1, value2, "numberFloors");
            return (Criteria) this;
        }

        public Criteria andNumberFloorsNotBetween(Integer value1, Integer value2) {
            addCriterion("number_floors not between", value1, value2, "numberFloors");
            return (Criteria) this;
        }

        public Criteria andYearOpenedIsNull() {
            addCriterion("year_opened is null");
            return (Criteria) this;
        }

        public Criteria andYearOpenedIsNotNull() {
            addCriterion("year_opened is not null");
            return (Criteria) this;
        }

        public Criteria andYearOpenedEqualTo(Integer value) {
            addCriterion("year_opened =", value, "yearOpened");
            return (Criteria) this;
        }

        public Criteria andYearOpenedNotEqualTo(Integer value) {
            addCriterion("year_opened <>", value, "yearOpened");
            return (Criteria) this;
        }

        public Criteria andYearOpenedGreaterThan(Integer value) {
            addCriterion("year_opened >", value, "yearOpened");
            return (Criteria) this;
        }

        public Criteria andYearOpenedGreaterThanOrEqualTo(Integer value) {
            addCriterion("year_opened >=", value, "yearOpened");
            return (Criteria) this;
        }

        public Criteria andYearOpenedLessThan(Integer value) {
            addCriterion("year_opened <", value, "yearOpened");
            return (Criteria) this;
        }

        public Criteria andYearOpenedLessThanOrEqualTo(Integer value) {
            addCriterion("year_opened <=", value, "yearOpened");
            return (Criteria) this;
        }

        public Criteria andYearOpenedIn(List<Integer> values) {
            addCriterion("year_opened in", values, "yearOpened");
            return (Criteria) this;
        }

        public Criteria andYearOpenedNotIn(List<Integer> values) {
            addCriterion("year_opened not in", values, "yearOpened");
            return (Criteria) this;
        }

        public Criteria andYearOpenedBetween(Integer value1, Integer value2) {
            addCriterion("year_opened between", value1, value2, "yearOpened");
            return (Criteria) this;
        }

        public Criteria andYearOpenedNotBetween(Integer value1, Integer value2) {
            addCriterion("year_opened not between", value1, value2, "yearOpened");
            return (Criteria) this;
        }

        public Criteria andYearRenovaatedIsNull() {
            addCriterion("year_renovaated is null");
            return (Criteria) this;
        }

        public Criteria andYearRenovaatedIsNotNull() {
            addCriterion("year_renovaated is not null");
            return (Criteria) this;
        }

        public Criteria andYearRenovaatedEqualTo(Integer value) {
            addCriterion("year_renovaated =", value, "yearRenovaated");
            return (Criteria) this;
        }

        public Criteria andYearRenovaatedNotEqualTo(Integer value) {
            addCriterion("year_renovaated <>", value, "yearRenovaated");
            return (Criteria) this;
        }

        public Criteria andYearRenovaatedGreaterThan(Integer value) {
            addCriterion("year_renovaated >", value, "yearRenovaated");
            return (Criteria) this;
        }

        public Criteria andYearRenovaatedGreaterThanOrEqualTo(Integer value) {
            addCriterion("year_renovaated >=", value, "yearRenovaated");
            return (Criteria) this;
        }

        public Criteria andYearRenovaatedLessThan(Integer value) {
            addCriterion("year_renovaated <", value, "yearRenovaated");
            return (Criteria) this;
        }

        public Criteria andYearRenovaatedLessThanOrEqualTo(Integer value) {
            addCriterion("year_renovaated <=", value, "yearRenovaated");
            return (Criteria) this;
        }

        public Criteria andYearRenovaatedIn(List<Integer> values) {
            addCriterion("year_renovaated in", values, "yearRenovaated");
            return (Criteria) this;
        }

        public Criteria andYearRenovaatedNotIn(List<Integer> values) {
            addCriterion("year_renovaated not in", values, "yearRenovaated");
            return (Criteria) this;
        }

        public Criteria andYearRenovaatedBetween(Integer value1, Integer value2) {
            addCriterion("year_renovaated between", value1, value2, "yearRenovaated");
            return (Criteria) this;
        }

        public Criteria andYearRenovaatedNotBetween(Integer value1, Integer value2) {
            addCriterion("year_renovaated not between", value1, value2, "yearRenovaated");
            return (Criteria) this;
        }

        public Criteria andPhoto1IsNull() {
            addCriterion("photo1 is null");
            return (Criteria) this;
        }

        public Criteria andPhoto1IsNotNull() {
            addCriterion("photo1 is not null");
            return (Criteria) this;
        }

        public Criteria andPhoto1EqualTo(String value) {
            addCriterion("photo1 =", value, "photo1");
            return (Criteria) this;
        }

        public Criteria andPhoto1NotEqualTo(String value) {
            addCriterion("photo1 <>", value, "photo1");
            return (Criteria) this;
        }

        public Criteria andPhoto1GreaterThan(String value) {
            addCriterion("photo1 >", value, "photo1");
            return (Criteria) this;
        }

        public Criteria andPhoto1GreaterThanOrEqualTo(String value) {
            addCriterion("photo1 >=", value, "photo1");
            return (Criteria) this;
        }

        public Criteria andPhoto1LessThan(String value) {
            addCriterion("photo1 <", value, "photo1");
            return (Criteria) this;
        }

        public Criteria andPhoto1LessThanOrEqualTo(String value) {
            addCriterion("photo1 <=", value, "photo1");
            return (Criteria) this;
        }

        public Criteria andPhoto1Like(String value) {
            addCriterion("photo1 like", value, "photo1");
            return (Criteria) this;
        }

        public Criteria andPhoto1NotLike(String value) {
            addCriterion("photo1 not like", value, "photo1");
            return (Criteria) this;
        }

        public Criteria andPhoto1In(List<String> values) {
            addCriterion("photo1 in", values, "photo1");
            return (Criteria) this;
        }

        public Criteria andPhoto1NotIn(List<String> values) {
            addCriterion("photo1 not in", values, "photo1");
            return (Criteria) this;
        }

        public Criteria andPhoto1Between(String value1, String value2) {
            addCriterion("photo1 between", value1, value2, "photo1");
            return (Criteria) this;
        }

        public Criteria andPhoto1NotBetween(String value1, String value2) {
            addCriterion("photo1 not between", value1, value2, "photo1");
            return (Criteria) this;
        }

        public Criteria andPhoto2IsNull() {
            addCriterion("photo2 is null");
            return (Criteria) this;
        }

        public Criteria andPhoto2IsNotNull() {
            addCriterion("photo2 is not null");
            return (Criteria) this;
        }

        public Criteria andPhoto2EqualTo(String value) {
            addCriterion("photo2 =", value, "photo2");
            return (Criteria) this;
        }

        public Criteria andPhoto2NotEqualTo(String value) {
            addCriterion("photo2 <>", value, "photo2");
            return (Criteria) this;
        }

        public Criteria andPhoto2GreaterThan(String value) {
            addCriterion("photo2 >", value, "photo2");
            return (Criteria) this;
        }

        public Criteria andPhoto2GreaterThanOrEqualTo(String value) {
            addCriterion("photo2 >=", value, "photo2");
            return (Criteria) this;
        }

        public Criteria andPhoto2LessThan(String value) {
            addCriterion("photo2 <", value, "photo2");
            return (Criteria) this;
        }

        public Criteria andPhoto2LessThanOrEqualTo(String value) {
            addCriterion("photo2 <=", value, "photo2");
            return (Criteria) this;
        }

        public Criteria andPhoto2Like(String value) {
            addCriterion("photo2 like", value, "photo2");
            return (Criteria) this;
        }

        public Criteria andPhoto2NotLike(String value) {
            addCriterion("photo2 not like", value, "photo2");
            return (Criteria) this;
        }

        public Criteria andPhoto2In(List<String> values) {
            addCriterion("photo2 in", values, "photo2");
            return (Criteria) this;
        }

        public Criteria andPhoto2NotIn(List<String> values) {
            addCriterion("photo2 not in", values, "photo2");
            return (Criteria) this;
        }

        public Criteria andPhoto2Between(String value1, String value2) {
            addCriterion("photo2 between", value1, value2, "photo2");
            return (Criteria) this;
        }

        public Criteria andPhoto2NotBetween(String value1, String value2) {
            addCriterion("photo2 not between", value1, value2, "photo2");
            return (Criteria) this;
        }

        public Criteria andPhoto3IsNull() {
            addCriterion("photo3 is null");
            return (Criteria) this;
        }

        public Criteria andPhoto3IsNotNull() {
            addCriterion("photo3 is not null");
            return (Criteria) this;
        }

        public Criteria andPhoto3EqualTo(String value) {
            addCriterion("photo3 =", value, "photo3");
            return (Criteria) this;
        }

        public Criteria andPhoto3NotEqualTo(String value) {
            addCriterion("photo3 <>", value, "photo3");
            return (Criteria) this;
        }

        public Criteria andPhoto3GreaterThan(String value) {
            addCriterion("photo3 >", value, "photo3");
            return (Criteria) this;
        }

        public Criteria andPhoto3GreaterThanOrEqualTo(String value) {
            addCriterion("photo3 >=", value, "photo3");
            return (Criteria) this;
        }

        public Criteria andPhoto3LessThan(String value) {
            addCriterion("photo3 <", value, "photo3");
            return (Criteria) this;
        }

        public Criteria andPhoto3LessThanOrEqualTo(String value) {
            addCriterion("photo3 <=", value, "photo3");
            return (Criteria) this;
        }

        public Criteria andPhoto3Like(String value) {
            addCriterion("photo3 like", value, "photo3");
            return (Criteria) this;
        }

        public Criteria andPhoto3NotLike(String value) {
            addCriterion("photo3 not like", value, "photo3");
            return (Criteria) this;
        }

        public Criteria andPhoto3In(List<String> values) {
            addCriterion("photo3 in", values, "photo3");
            return (Criteria) this;
        }

        public Criteria andPhoto3NotIn(List<String> values) {
            addCriterion("photo3 not in", values, "photo3");
            return (Criteria) this;
        }

        public Criteria andPhoto3Between(String value1, String value2) {
            addCriterion("photo3 between", value1, value2, "photo3");
            return (Criteria) this;
        }

        public Criteria andPhoto3NotBetween(String value1, String value2) {
            addCriterion("photo3 not between", value1, value2, "photo3");
            return (Criteria) this;
        }

        public Criteria andPhoto4IsNull() {
            addCriterion("photo4 is null");
            return (Criteria) this;
        }

        public Criteria andPhoto4IsNotNull() {
            addCriterion("photo4 is not null");
            return (Criteria) this;
        }

        public Criteria andPhoto4EqualTo(String value) {
            addCriterion("photo4 =", value, "photo4");
            return (Criteria) this;
        }

        public Criteria andPhoto4NotEqualTo(String value) {
            addCriterion("photo4 <>", value, "photo4");
            return (Criteria) this;
        }

        public Criteria andPhoto4GreaterThan(String value) {
            addCriterion("photo4 >", value, "photo4");
            return (Criteria) this;
        }

        public Criteria andPhoto4GreaterThanOrEqualTo(String value) {
            addCriterion("photo4 >=", value, "photo4");
            return (Criteria) this;
        }

        public Criteria andPhoto4LessThan(String value) {
            addCriterion("photo4 <", value, "photo4");
            return (Criteria) this;
        }

        public Criteria andPhoto4LessThanOrEqualTo(String value) {
            addCriterion("photo4 <=", value, "photo4");
            return (Criteria) this;
        }

        public Criteria andPhoto4Like(String value) {
            addCriterion("photo4 like", value, "photo4");
            return (Criteria) this;
        }

        public Criteria andPhoto4NotLike(String value) {
            addCriterion("photo4 not like", value, "photo4");
            return (Criteria) this;
        }

        public Criteria andPhoto4In(List<String> values) {
            addCriterion("photo4 in", values, "photo4");
            return (Criteria) this;
        }

        public Criteria andPhoto4NotIn(List<String> values) {
            addCriterion("photo4 not in", values, "photo4");
            return (Criteria) this;
        }

        public Criteria andPhoto4Between(String value1, String value2) {
            addCriterion("photo4 between", value1, value2, "photo4");
            return (Criteria) this;
        }

        public Criteria andPhoto4NotBetween(String value1, String value2) {
            addCriterion("photo4 not between", value1, value2, "photo4");
            return (Criteria) this;
        }

        public Criteria andPhoto5IsNull() {
            addCriterion("photo5 is null");
            return (Criteria) this;
        }

        public Criteria andPhoto5IsNotNull() {
            addCriterion("photo5 is not null");
            return (Criteria) this;
        }

        public Criteria andPhoto5EqualTo(String value) {
            addCriterion("photo5 =", value, "photo5");
            return (Criteria) this;
        }

        public Criteria andPhoto5NotEqualTo(String value) {
            addCriterion("photo5 <>", value, "photo5");
            return (Criteria) this;
        }

        public Criteria andPhoto5GreaterThan(String value) {
            addCriterion("photo5 >", value, "photo5");
            return (Criteria) this;
        }

        public Criteria andPhoto5GreaterThanOrEqualTo(String value) {
            addCriterion("photo5 >=", value, "photo5");
            return (Criteria) this;
        }

        public Criteria andPhoto5LessThan(String value) {
            addCriterion("photo5 <", value, "photo5");
            return (Criteria) this;
        }

        public Criteria andPhoto5LessThanOrEqualTo(String value) {
            addCriterion("photo5 <=", value, "photo5");
            return (Criteria) this;
        }

        public Criteria andPhoto5Like(String value) {
            addCriterion("photo5 like", value, "photo5");
            return (Criteria) this;
        }

        public Criteria andPhoto5NotLike(String value) {
            addCriterion("photo5 not like", value, "photo5");
            return (Criteria) this;
        }

        public Criteria andPhoto5In(List<String> values) {
            addCriterion("photo5 in", values, "photo5");
            return (Criteria) this;
        }

        public Criteria andPhoto5NotIn(List<String> values) {
            addCriterion("photo5 not in", values, "photo5");
            return (Criteria) this;
        }

        public Criteria andPhoto5Between(String value1, String value2) {
            addCriterion("photo5 between", value1, value2, "photo5");
            return (Criteria) this;
        }

        public Criteria andPhoto5NotBetween(String value1, String value2) {
            addCriterion("photo5 not between", value1, value2, "photo5");
            return (Criteria) this;
        }

        public Criteria andOverviewIsNull() {
            addCriterion("overview is null");
            return (Criteria) this;
        }

        public Criteria andOverviewIsNotNull() {
            addCriterion("overview is not null");
            return (Criteria) this;
        }

        public Criteria andOverviewEqualTo(String value) {
            addCriterion("overview =", value, "overview");
            return (Criteria) this;
        }

        public Criteria andOverviewNotEqualTo(String value) {
            addCriterion("overview <>", value, "overview");
            return (Criteria) this;
        }

        public Criteria andOverviewGreaterThan(String value) {
            addCriterion("overview >", value, "overview");
            return (Criteria) this;
        }

        public Criteria andOverviewGreaterThanOrEqualTo(String value) {
            addCriterion("overview >=", value, "overview");
            return (Criteria) this;
        }

        public Criteria andOverviewLessThan(String value) {
            addCriterion("overview <", value, "overview");
            return (Criteria) this;
        }

        public Criteria andOverviewLessThanOrEqualTo(String value) {
            addCriterion("overview <=", value, "overview");
            return (Criteria) this;
        }

        public Criteria andOverviewLike(String value) {
            addCriterion("overview like", value, "overview");
            return (Criteria) this;
        }

        public Criteria andOverviewNotLike(String value) {
            addCriterion("overview not like", value, "overview");
            return (Criteria) this;
        }

        public Criteria andOverviewIn(List<String> values) {
            addCriterion("overview in", values, "overview");
            return (Criteria) this;
        }

        public Criteria andOverviewNotIn(List<String> values) {
            addCriterion("overview not in", values, "overview");
            return (Criteria) this;
        }

        public Criteria andOverviewBetween(String value1, String value2) {
            addCriterion("overview between", value1, value2, "overview");
            return (Criteria) this;
        }

        public Criteria andOverviewNotBetween(String value1, String value2) {
            addCriterion("overview not between", value1, value2, "overview");
            return (Criteria) this;
        }

        public Criteria andRatesFromIsNull() {
            addCriterion("rates_from is null");
            return (Criteria) this;
        }

        public Criteria andRatesFromIsNotNull() {
            addCriterion("rates_from is not null");
            return (Criteria) this;
        }

        public Criteria andRatesFromEqualTo(Integer value) {
            addCriterion("rates_from =", value, "ratesFrom");
            return (Criteria) this;
        }

        public Criteria andRatesFromNotEqualTo(Integer value) {
            addCriterion("rates_from <>", value, "ratesFrom");
            return (Criteria) this;
        }

        public Criteria andRatesFromGreaterThan(Integer value) {
            addCriterion("rates_from >", value, "ratesFrom");
            return (Criteria) this;
        }

        public Criteria andRatesFromGreaterThanOrEqualTo(Integer value) {
            addCriterion("rates_from >=", value, "ratesFrom");
            return (Criteria) this;
        }

        public Criteria andRatesFromLessThan(Integer value) {
            addCriterion("rates_from <", value, "ratesFrom");
            return (Criteria) this;
        }

        public Criteria andRatesFromLessThanOrEqualTo(Integer value) {
            addCriterion("rates_from <=", value, "ratesFrom");
            return (Criteria) this;
        }

        public Criteria andRatesFromIn(List<Integer> values) {
            addCriterion("rates_from in", values, "ratesFrom");
            return (Criteria) this;
        }

        public Criteria andRatesFromNotIn(List<Integer> values) {
            addCriterion("rates_from not in", values, "ratesFrom");
            return (Criteria) this;
        }

        public Criteria andRatesFromBetween(Integer value1, Integer value2) {
            addCriterion("rates_from between", value1, value2, "ratesFrom");
            return (Criteria) this;
        }

        public Criteria andRatesFromNotBetween(Integer value1, Integer value2) {
            addCriterion("rates_from not between", value1, value2, "ratesFrom");
            return (Criteria) this;
        }

        public Criteria andContinentIdIsNull() {
            addCriterion("continent_id is null");
            return (Criteria) this;
        }

        public Criteria andContinentIdIsNotNull() {
            addCriterion("continent_id is not null");
            return (Criteria) this;
        }

        public Criteria andContinentIdEqualTo(Integer value) {
            addCriterion("continent_id =", value, "continentId");
            return (Criteria) this;
        }

        public Criteria andContinentIdNotEqualTo(Integer value) {
            addCriterion("continent_id <>", value, "continentId");
            return (Criteria) this;
        }

        public Criteria andContinentIdGreaterThan(Integer value) {
            addCriterion("continent_id >", value, "continentId");
            return (Criteria) this;
        }

        public Criteria andContinentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("continent_id >=", value, "continentId");
            return (Criteria) this;
        }

        public Criteria andContinentIdLessThan(Integer value) {
            addCriterion("continent_id <", value, "continentId");
            return (Criteria) this;
        }

        public Criteria andContinentIdLessThanOrEqualTo(Integer value) {
            addCriterion("continent_id <=", value, "continentId");
            return (Criteria) this;
        }

        public Criteria andContinentIdIn(List<Integer> values) {
            addCriterion("continent_id in", values, "continentId");
            return (Criteria) this;
        }

        public Criteria andContinentIdNotIn(List<Integer> values) {
            addCriterion("continent_id not in", values, "continentId");
            return (Criteria) this;
        }

        public Criteria andContinentIdBetween(Integer value1, Integer value2) {
            addCriterion("continent_id between", value1, value2, "continentId");
            return (Criteria) this;
        }

        public Criteria andContinentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("continent_id not between", value1, value2, "continentId");
            return (Criteria) this;
        }

        public Criteria andContinentNameIsNull() {
            addCriterion("continent_name is null");
            return (Criteria) this;
        }

        public Criteria andContinentNameIsNotNull() {
            addCriterion("continent_name is not null");
            return (Criteria) this;
        }

        public Criteria andContinentNameEqualTo(String value) {
            addCriterion("continent_name =", value, "continentName");
            return (Criteria) this;
        }

        public Criteria andContinentNameNotEqualTo(String value) {
            addCriterion("continent_name <>", value, "continentName");
            return (Criteria) this;
        }

        public Criteria andContinentNameGreaterThan(String value) {
            addCriterion("continent_name >", value, "continentName");
            return (Criteria) this;
        }

        public Criteria andContinentNameGreaterThanOrEqualTo(String value) {
            addCriterion("continent_name >=", value, "continentName");
            return (Criteria) this;
        }

        public Criteria andContinentNameLessThan(String value) {
            addCriterion("continent_name <", value, "continentName");
            return (Criteria) this;
        }

        public Criteria andContinentNameLessThanOrEqualTo(String value) {
            addCriterion("continent_name <=", value, "continentName");
            return (Criteria) this;
        }

        public Criteria andContinentNameLike(String value) {
            addCriterion("continent_name like", value, "continentName");
            return (Criteria) this;
        }

        public Criteria andContinentNameNotLike(String value) {
            addCriterion("continent_name not like", value, "continentName");
            return (Criteria) this;
        }

        public Criteria andContinentNameIn(List<String> values) {
            addCriterion("continent_name in", values, "continentName");
            return (Criteria) this;
        }

        public Criteria andContinentNameNotIn(List<String> values) {
            addCriterion("continent_name not in", values, "continentName");
            return (Criteria) this;
        }

        public Criteria andContinentNameBetween(String value1, String value2) {
            addCriterion("continent_name between", value1, value2, "continentName");
            return (Criteria) this;
        }

        public Criteria andContinentNameNotBetween(String value1, String value2) {
            addCriterion("continent_name not between", value1, value2, "continentName");
            return (Criteria) this;
        }

        public Criteria andCityIdIsNull() {
            addCriterion("city_id is null");
            return (Criteria) this;
        }

        public Criteria andCityIdIsNotNull() {
            addCriterion("city_id is not null");
            return (Criteria) this;
        }

        public Criteria andCityIdEqualTo(Integer value) {
            addCriterion("city_id =", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdNotEqualTo(Integer value) {
            addCriterion("city_id <>", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdGreaterThan(Integer value) {
            addCriterion("city_id >", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("city_id >=", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdLessThan(Integer value) {
            addCriterion("city_id <", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdLessThanOrEqualTo(Integer value) {
            addCriterion("city_id <=", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdIn(List<Integer> values) {
            addCriterion("city_id in", values, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdNotIn(List<Integer> values) {
            addCriterion("city_id not in", values, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdBetween(Integer value1, Integer value2) {
            addCriterion("city_id between", value1, value2, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdNotBetween(Integer value1, Integer value2) {
            addCriterion("city_id not between", value1, value2, "cityId");
            return (Criteria) this;
        }

        public Criteria andCountryIdIsNull() {
            addCriterion("country_id is null");
            return (Criteria) this;
        }

        public Criteria andCountryIdIsNotNull() {
            addCriterion("country_id is not null");
            return (Criteria) this;
        }

        public Criteria andCountryIdEqualTo(Integer value) {
            addCriterion("country_id =", value, "countryId");
            return (Criteria) this;
        }

        public Criteria andCountryIdNotEqualTo(Integer value) {
            addCriterion("country_id <>", value, "countryId");
            return (Criteria) this;
        }

        public Criteria andCountryIdGreaterThan(Integer value) {
            addCriterion("country_id >", value, "countryId");
            return (Criteria) this;
        }

        public Criteria andCountryIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("country_id >=", value, "countryId");
            return (Criteria) this;
        }

        public Criteria andCountryIdLessThan(Integer value) {
            addCriterion("country_id <", value, "countryId");
            return (Criteria) this;
        }

        public Criteria andCountryIdLessThanOrEqualTo(Integer value) {
            addCriterion("country_id <=", value, "countryId");
            return (Criteria) this;
        }

        public Criteria andCountryIdIn(List<Integer> values) {
            addCriterion("country_id in", values, "countryId");
            return (Criteria) this;
        }

        public Criteria andCountryIdNotIn(List<Integer> values) {
            addCriterion("country_id not in", values, "countryId");
            return (Criteria) this;
        }

        public Criteria andCountryIdBetween(Integer value1, Integer value2) {
            addCriterion("country_id between", value1, value2, "countryId");
            return (Criteria) this;
        }

        public Criteria andCountryIdNotBetween(Integer value1, Integer value2) {
            addCriterion("country_id not between", value1, value2, "countryId");
            return (Criteria) this;
        }

        public Criteria andNumberOfReviewsIsNull() {
            addCriterion("number_of_reviews is null");
            return (Criteria) this;
        }

        public Criteria andNumberOfReviewsIsNotNull() {
            addCriterion("number_of_reviews is not null");
            return (Criteria) this;
        }

        public Criteria andNumberOfReviewsEqualTo(Integer value) {
            addCriterion("number_of_reviews =", value, "numberOfReviews");
            return (Criteria) this;
        }

        public Criteria andNumberOfReviewsNotEqualTo(Integer value) {
            addCriterion("number_of_reviews <>", value, "numberOfReviews");
            return (Criteria) this;
        }

        public Criteria andNumberOfReviewsGreaterThan(Integer value) {
            addCriterion("number_of_reviews >", value, "numberOfReviews");
            return (Criteria) this;
        }

        public Criteria andNumberOfReviewsGreaterThanOrEqualTo(Integer value) {
            addCriterion("number_of_reviews >=", value, "numberOfReviews");
            return (Criteria) this;
        }

        public Criteria andNumberOfReviewsLessThan(Integer value) {
            addCriterion("number_of_reviews <", value, "numberOfReviews");
            return (Criteria) this;
        }

        public Criteria andNumberOfReviewsLessThanOrEqualTo(Integer value) {
            addCriterion("number_of_reviews <=", value, "numberOfReviews");
            return (Criteria) this;
        }

        public Criteria andNumberOfReviewsIn(List<Integer> values) {
            addCriterion("number_of_reviews in", values, "numberOfReviews");
            return (Criteria) this;
        }

        public Criteria andNumberOfReviewsNotIn(List<Integer> values) {
            addCriterion("number_of_reviews not in", values, "numberOfReviews");
            return (Criteria) this;
        }

        public Criteria andNumberOfReviewsBetween(Integer value1, Integer value2) {
            addCriterion("number_of_reviews between", value1, value2, "numberOfReviews");
            return (Criteria) this;
        }

        public Criteria andNumberOfReviewsNotBetween(Integer value1, Integer value2) {
            addCriterion("number_of_reviews not between", value1, value2, "numberOfReviews");
            return (Criteria) this;
        }

        public Criteria andRatingAverageIsNull() {
            addCriterion("rating_average is null");
            return (Criteria) this;
        }

        public Criteria andRatingAverageIsNotNull() {
            addCriterion("rating_average is not null");
            return (Criteria) this;
        }

        public Criteria andRatingAverageEqualTo(Integer value) {
            addCriterion("rating_average =", value, "ratingAverage");
            return (Criteria) this;
        }

        public Criteria andRatingAverageNotEqualTo(Integer value) {
            addCriterion("rating_average <>", value, "ratingAverage");
            return (Criteria) this;
        }

        public Criteria andRatingAverageGreaterThan(Integer value) {
            addCriterion("rating_average >", value, "ratingAverage");
            return (Criteria) this;
        }

        public Criteria andRatingAverageGreaterThanOrEqualTo(Integer value) {
            addCriterion("rating_average >=", value, "ratingAverage");
            return (Criteria) this;
        }

        public Criteria andRatingAverageLessThan(Integer value) {
            addCriterion("rating_average <", value, "ratingAverage");
            return (Criteria) this;
        }

        public Criteria andRatingAverageLessThanOrEqualTo(Integer value) {
            addCriterion("rating_average <=", value, "ratingAverage");
            return (Criteria) this;
        }

        public Criteria andRatingAverageIn(List<Integer> values) {
            addCriterion("rating_average in", values, "ratingAverage");
            return (Criteria) this;
        }

        public Criteria andRatingAverageNotIn(List<Integer> values) {
            addCriterion("rating_average not in", values, "ratingAverage");
            return (Criteria) this;
        }

        public Criteria andRatingAverageBetween(Integer value1, Integer value2) {
            addCriterion("rating_average between", value1, value2, "ratingAverage");
            return (Criteria) this;
        }

        public Criteria andRatingAverageNotBetween(Integer value1, Integer value2) {
            addCriterion("rating_average not between", value1, value2, "ratingAverage");
            return (Criteria) this;
        }

        public Criteria andRatesCurrencyIsNull() {
            addCriterion("rates_currency is null");
            return (Criteria) this;
        }

        public Criteria andRatesCurrencyIsNotNull() {
            addCriterion("rates_currency is not null");
            return (Criteria) this;
        }

        public Criteria andRatesCurrencyEqualTo(String value) {
            addCriterion("rates_currency =", value, "ratesCurrency");
            return (Criteria) this;
        }

        public Criteria andRatesCurrencyNotEqualTo(String value) {
            addCriterion("rates_currency <>", value, "ratesCurrency");
            return (Criteria) this;
        }

        public Criteria andRatesCurrencyGreaterThan(String value) {
            addCriterion("rates_currency >", value, "ratesCurrency");
            return (Criteria) this;
        }

        public Criteria andRatesCurrencyGreaterThanOrEqualTo(String value) {
            addCriterion("rates_currency >=", value, "ratesCurrency");
            return (Criteria) this;
        }

        public Criteria andRatesCurrencyLessThan(String value) {
            addCriterion("rates_currency <", value, "ratesCurrency");
            return (Criteria) this;
        }

        public Criteria andRatesCurrencyLessThanOrEqualTo(String value) {
            addCriterion("rates_currency <=", value, "ratesCurrency");
            return (Criteria) this;
        }

        public Criteria andRatesCurrencyLike(String value) {
            addCriterion("rates_currency like", value, "ratesCurrency");
            return (Criteria) this;
        }

        public Criteria andRatesCurrencyNotLike(String value) {
            addCriterion("rates_currency not like", value, "ratesCurrency");
            return (Criteria) this;
        }

        public Criteria andRatesCurrencyIn(List<String> values) {
            addCriterion("rates_currency in", values, "ratesCurrency");
            return (Criteria) this;
        }

        public Criteria andRatesCurrencyNotIn(List<String> values) {
            addCriterion("rates_currency not in", values, "ratesCurrency");
            return (Criteria) this;
        }

        public Criteria andRatesCurrencyBetween(String value1, String value2) {
            addCriterion("rates_currency between", value1, value2, "ratesCurrency");
            return (Criteria) this;
        }

        public Criteria andRatesCurrencyNotBetween(String value1, String value2) {
            addCriterion("rates_currency not between", value1, value2, "ratesCurrency");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}