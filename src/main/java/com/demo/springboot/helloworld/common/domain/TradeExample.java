package com.demo.springboot.helloworld.common.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TradeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TradeExample() {
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

        public Criteria andOutTradeNoIsNull() {
            addCriterion("out_trade_no is null");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoIsNotNull() {
            addCriterion("out_trade_no is not null");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoEqualTo(Integer value) {
            addCriterion("out_trade_no =", value, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoNotEqualTo(Integer value) {
            addCriterion("out_trade_no <>", value, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoGreaterThan(Integer value) {
            addCriterion("out_trade_no >", value, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("out_trade_no >=", value, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoLessThan(Integer value) {
            addCriterion("out_trade_no <", value, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoLessThanOrEqualTo(Integer value) {
            addCriterion("out_trade_no <=", value, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoIn(List<Integer> values) {
            addCriterion("out_trade_no in", values, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoNotIn(List<Integer> values) {
            addCriterion("out_trade_no not in", values, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoBetween(Integer value1, Integer value2) {
            addCriterion("out_trade_no between", value1, value2, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoNotBetween(Integer value1, Integer value2) {
            addCriterion("out_trade_no not between", value1, value2, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoIsNull() {
            addCriterion("trade_no is null");
            return (Criteria) this;
        }

        public Criteria andTradeNoIsNotNull() {
            addCriterion("trade_no is not null");
            return (Criteria) this;
        }

        public Criteria andTradeNoEqualTo(String value) {
            addCriterion("trade_no =", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoNotEqualTo(String value) {
            addCriterion("trade_no <>", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoGreaterThan(String value) {
            addCriterion("trade_no >", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoGreaterThanOrEqualTo(String value) {
            addCriterion("trade_no >=", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoLessThan(String value) {
            addCriterion("trade_no <", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoLessThanOrEqualTo(String value) {
            addCriterion("trade_no <=", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoLike(String value) {
            addCriterion("trade_no like", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoNotLike(String value) {
            addCriterion("trade_no not like", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoIn(List<String> values) {
            addCriterion("trade_no in", values, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoNotIn(List<String> values) {
            addCriterion("trade_no not in", values, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoBetween(String value1, String value2) {
            addCriterion("trade_no between", value1, value2, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoNotBetween(String value1, String value2) {
            addCriterion("trade_no not between", value1, value2, "tradeNo");
            return (Criteria) this;
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

        public Criteria andTradeAmountIsNull() {
            addCriterion("trade_amount is null");
            return (Criteria) this;
        }

        public Criteria andTradeAmountIsNotNull() {
            addCriterion("trade_amount is not null");
            return (Criteria) this;
        }

        public Criteria andTradeAmountEqualTo(Long value) {
            addCriterion("trade_amount =", value, "tradeAmount");
            return (Criteria) this;
        }

        public Criteria andTradeAmountNotEqualTo(Long value) {
            addCriterion("trade_amount <>", value, "tradeAmount");
            return (Criteria) this;
        }

        public Criteria andTradeAmountGreaterThan(Long value) {
            addCriterion("trade_amount >", value, "tradeAmount");
            return (Criteria) this;
        }

        public Criteria andTradeAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("trade_amount >=", value, "tradeAmount");
            return (Criteria) this;
        }

        public Criteria andTradeAmountLessThan(Long value) {
            addCriterion("trade_amount <", value, "tradeAmount");
            return (Criteria) this;
        }

        public Criteria andTradeAmountLessThanOrEqualTo(Long value) {
            addCriterion("trade_amount <=", value, "tradeAmount");
            return (Criteria) this;
        }

        public Criteria andTradeAmountIn(List<Long> values) {
            addCriterion("trade_amount in", values, "tradeAmount");
            return (Criteria) this;
        }

        public Criteria andTradeAmountNotIn(List<Long> values) {
            addCriterion("trade_amount not in", values, "tradeAmount");
            return (Criteria) this;
        }

        public Criteria andTradeAmountBetween(Long value1, Long value2) {
            addCriterion("trade_amount between", value1, value2, "tradeAmount");
            return (Criteria) this;
        }

        public Criteria andTradeAmountNotBetween(Long value1, Long value2) {
            addCriterion("trade_amount not between", value1, value2, "tradeAmount");
            return (Criteria) this;
        }

        public Criteria andTradeCommentIsNull() {
            addCriterion("trade_comment is null");
            return (Criteria) this;
        }

        public Criteria andTradeCommentIsNotNull() {
            addCriterion("trade_comment is not null");
            return (Criteria) this;
        }

        public Criteria andTradeCommentEqualTo(String value) {
            addCriterion("trade_comment =", value, "tradeComment");
            return (Criteria) this;
        }

        public Criteria andTradeCommentNotEqualTo(String value) {
            addCriterion("trade_comment <>", value, "tradeComment");
            return (Criteria) this;
        }

        public Criteria andTradeCommentGreaterThan(String value) {
            addCriterion("trade_comment >", value, "tradeComment");
            return (Criteria) this;
        }

        public Criteria andTradeCommentGreaterThanOrEqualTo(String value) {
            addCriterion("trade_comment >=", value, "tradeComment");
            return (Criteria) this;
        }

        public Criteria andTradeCommentLessThan(String value) {
            addCriterion("trade_comment <", value, "tradeComment");
            return (Criteria) this;
        }

        public Criteria andTradeCommentLessThanOrEqualTo(String value) {
            addCriterion("trade_comment <=", value, "tradeComment");
            return (Criteria) this;
        }

        public Criteria andTradeCommentLike(String value) {
            addCriterion("trade_comment like", value, "tradeComment");
            return (Criteria) this;
        }

        public Criteria andTradeCommentNotLike(String value) {
            addCriterion("trade_comment not like", value, "tradeComment");
            return (Criteria) this;
        }

        public Criteria andTradeCommentIn(List<String> values) {
            addCriterion("trade_comment in", values, "tradeComment");
            return (Criteria) this;
        }

        public Criteria andTradeCommentNotIn(List<String> values) {
            addCriterion("trade_comment not in", values, "tradeComment");
            return (Criteria) this;
        }

        public Criteria andTradeCommentBetween(String value1, String value2) {
            addCriterion("trade_comment between", value1, value2, "tradeComment");
            return (Criteria) this;
        }

        public Criteria andTradeCommentNotBetween(String value1, String value2) {
            addCriterion("trade_comment not between", value1, value2, "tradeComment");
            return (Criteria) this;
        }

        public Criteria andTradeUserIdIsNull() {
            addCriterion("trade_user_id is null");
            return (Criteria) this;
        }

        public Criteria andTradeUserIdIsNotNull() {
            addCriterion("trade_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andTradeUserIdEqualTo(Integer value) {
            addCriterion("trade_user_id =", value, "tradeUserId");
            return (Criteria) this;
        }

        public Criteria andTradeUserIdNotEqualTo(Integer value) {
            addCriterion("trade_user_id <>", value, "tradeUserId");
            return (Criteria) this;
        }

        public Criteria andTradeUserIdGreaterThan(Integer value) {
            addCriterion("trade_user_id >", value, "tradeUserId");
            return (Criteria) this;
        }

        public Criteria andTradeUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("trade_user_id >=", value, "tradeUserId");
            return (Criteria) this;
        }

        public Criteria andTradeUserIdLessThan(Integer value) {
            addCriterion("trade_user_id <", value, "tradeUserId");
            return (Criteria) this;
        }

        public Criteria andTradeUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("trade_user_id <=", value, "tradeUserId");
            return (Criteria) this;
        }

        public Criteria andTradeUserIdIn(List<Integer> values) {
            addCriterion("trade_user_id in", values, "tradeUserId");
            return (Criteria) this;
        }

        public Criteria andTradeUserIdNotIn(List<Integer> values) {
            addCriterion("trade_user_id not in", values, "tradeUserId");
            return (Criteria) this;
        }

        public Criteria andTradeUserIdBetween(Integer value1, Integer value2) {
            addCriterion("trade_user_id between", value1, value2, "tradeUserId");
            return (Criteria) this;
        }

        public Criteria andTradeUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("trade_user_id not between", value1, value2, "tradeUserId");
            return (Criteria) this;
        }

        public Criteria andTradeCreateTimeIsNull() {
            addCriterion("trade_create_time is null");
            return (Criteria) this;
        }

        public Criteria andTradeCreateTimeIsNotNull() {
            addCriterion("trade_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andTradeCreateTimeEqualTo(Date value) {
            addCriterion("trade_create_time =", value, "tradeCreateTime");
            return (Criteria) this;
        }

        public Criteria andTradeCreateTimeNotEqualTo(Date value) {
            addCriterion("trade_create_time <>", value, "tradeCreateTime");
            return (Criteria) this;
        }

        public Criteria andTradeCreateTimeGreaterThan(Date value) {
            addCriterion("trade_create_time >", value, "tradeCreateTime");
            return (Criteria) this;
        }

        public Criteria andTradeCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("trade_create_time >=", value, "tradeCreateTime");
            return (Criteria) this;
        }

        public Criteria andTradeCreateTimeLessThan(Date value) {
            addCriterion("trade_create_time <", value, "tradeCreateTime");
            return (Criteria) this;
        }

        public Criteria andTradeCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("trade_create_time <=", value, "tradeCreateTime");
            return (Criteria) this;
        }

        public Criteria andTradeCreateTimeIn(List<Date> values) {
            addCriterion("trade_create_time in", values, "tradeCreateTime");
            return (Criteria) this;
        }

        public Criteria andTradeCreateTimeNotIn(List<Date> values) {
            addCriterion("trade_create_time not in", values, "tradeCreateTime");
            return (Criteria) this;
        }

        public Criteria andTradeCreateTimeBetween(Date value1, Date value2) {
            addCriterion("trade_create_time between", value1, value2, "tradeCreateTime");
            return (Criteria) this;
        }

        public Criteria andTradeCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("trade_create_time not between", value1, value2, "tradeCreateTime");
            return (Criteria) this;
        }

        public Criteria andTradeTitleIsNull() {
            addCriterion("trade_title is null");
            return (Criteria) this;
        }

        public Criteria andTradeTitleIsNotNull() {
            addCriterion("trade_title is not null");
            return (Criteria) this;
        }

        public Criteria andTradeTitleEqualTo(String value) {
            addCriterion("trade_title =", value, "tradeTitle");
            return (Criteria) this;
        }

        public Criteria andTradeTitleNotEqualTo(String value) {
            addCriterion("trade_title <>", value, "tradeTitle");
            return (Criteria) this;
        }

        public Criteria andTradeTitleGreaterThan(String value) {
            addCriterion("trade_title >", value, "tradeTitle");
            return (Criteria) this;
        }

        public Criteria andTradeTitleGreaterThanOrEqualTo(String value) {
            addCriterion("trade_title >=", value, "tradeTitle");
            return (Criteria) this;
        }

        public Criteria andTradeTitleLessThan(String value) {
            addCriterion("trade_title <", value, "tradeTitle");
            return (Criteria) this;
        }

        public Criteria andTradeTitleLessThanOrEqualTo(String value) {
            addCriterion("trade_title <=", value, "tradeTitle");
            return (Criteria) this;
        }

        public Criteria andTradeTitleLike(String value) {
            addCriterion("trade_title like", value, "tradeTitle");
            return (Criteria) this;
        }

        public Criteria andTradeTitleNotLike(String value) {
            addCriterion("trade_title not like", value, "tradeTitle");
            return (Criteria) this;
        }

        public Criteria andTradeTitleIn(List<String> values) {
            addCriterion("trade_title in", values, "tradeTitle");
            return (Criteria) this;
        }

        public Criteria andTradeTitleNotIn(List<String> values) {
            addCriterion("trade_title not in", values, "tradeTitle");
            return (Criteria) this;
        }

        public Criteria andTradeTitleBetween(String value1, String value2) {
            addCriterion("trade_title between", value1, value2, "tradeTitle");
            return (Criteria) this;
        }

        public Criteria andTradeTitleNotBetween(String value1, String value2) {
            addCriterion("trade_title not between", value1, value2, "tradeTitle");
            return (Criteria) this;
        }

        public Criteria andTradeStateIsNull() {
            addCriterion("trade_state is null");
            return (Criteria) this;
        }

        public Criteria andTradeStateIsNotNull() {
            addCriterion("trade_state is not null");
            return (Criteria) this;
        }

        public Criteria andTradeStateEqualTo(Integer value) {
            addCriterion("trade_state =", value, "tradeState");
            return (Criteria) this;
        }

        public Criteria andTradeStateNotEqualTo(Integer value) {
            addCriterion("trade_state <>", value, "tradeState");
            return (Criteria) this;
        }

        public Criteria andTradeStateGreaterThan(Integer value) {
            addCriterion("trade_state >", value, "tradeState");
            return (Criteria) this;
        }

        public Criteria andTradeStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("trade_state >=", value, "tradeState");
            return (Criteria) this;
        }

        public Criteria andTradeStateLessThan(Integer value) {
            addCriterion("trade_state <", value, "tradeState");
            return (Criteria) this;
        }

        public Criteria andTradeStateLessThanOrEqualTo(Integer value) {
            addCriterion("trade_state <=", value, "tradeState");
            return (Criteria) this;
        }

        public Criteria andTradeStateIn(List<Integer> values) {
            addCriterion("trade_state in", values, "tradeState");
            return (Criteria) this;
        }

        public Criteria andTradeStateNotIn(List<Integer> values) {
            addCriterion("trade_state not in", values, "tradeState");
            return (Criteria) this;
        }

        public Criteria andTradeStateBetween(Integer value1, Integer value2) {
            addCriterion("trade_state between", value1, value2, "tradeState");
            return (Criteria) this;
        }

        public Criteria andTradeStateNotBetween(Integer value1, Integer value2) {
            addCriterion("trade_state not between", value1, value2, "tradeState");
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