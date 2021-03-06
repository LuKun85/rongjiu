package com.company.core.dao;

import java.util.ArrayList;
import java.util.List;

public class TblSmsRouteDAOExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table TBL_SMS_ROUTE
     *
     * @mbggenerated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table TBL_SMS_ROUTE
     *
     * @mbggenerated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table TBL_SMS_ROUTE
     *
     * @mbggenerated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TBL_SMS_ROUTE
     *
     * @mbggenerated
     */
    public TblSmsRouteDAOExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TBL_SMS_ROUTE
     *
     * @mbggenerated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TBL_SMS_ROUTE
     *
     * @mbggenerated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TBL_SMS_ROUTE
     *
     * @mbggenerated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TBL_SMS_ROUTE
     *
     * @mbggenerated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TBL_SMS_ROUTE
     *
     * @mbggenerated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TBL_SMS_ROUTE
     *
     * @mbggenerated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TBL_SMS_ROUTE
     *
     * @mbggenerated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TBL_SMS_ROUTE
     *
     * @mbggenerated
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TBL_SMS_ROUTE
     *
     * @mbggenerated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TBL_SMS_ROUTE
     *
     * @mbggenerated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table TBL_SMS_ROUTE
     *
     * @mbggenerated
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
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

        public Criteria andSmsCodeIsNull() {
            addCriterion("SMS_CODE is null");
            return (Criteria) this;
        }

        public Criteria andSmsCodeIsNotNull() {
            addCriterion("SMS_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andSmsCodeEqualTo(String value) {
            addCriterion("SMS_CODE =", value, "smsCode");
            return (Criteria) this;
        }

        public Criteria andSmsCodeNotEqualTo(String value) {
            addCriterion("SMS_CODE <>", value, "smsCode");
            return (Criteria) this;
        }

        public Criteria andSmsCodeGreaterThan(String value) {
            addCriterion("SMS_CODE >", value, "smsCode");
            return (Criteria) this;
        }

        public Criteria andSmsCodeGreaterThanOrEqualTo(String value) {
            addCriterion("SMS_CODE >=", value, "smsCode");
            return (Criteria) this;
        }

        public Criteria andSmsCodeLessThan(String value) {
            addCriterion("SMS_CODE <", value, "smsCode");
            return (Criteria) this;
        }

        public Criteria andSmsCodeLessThanOrEqualTo(String value) {
            addCriterion("SMS_CODE <=", value, "smsCode");
            return (Criteria) this;
        }

        public Criteria andSmsCodeLike(String value) {
            addCriterion("SMS_CODE like", value, "smsCode");
            return (Criteria) this;
        }

        public Criteria andSmsCodeNotLike(String value) {
            addCriterion("SMS_CODE not like", value, "smsCode");
            return (Criteria) this;
        }

        public Criteria andSmsCodeIn(List<String> values) {
            addCriterion("SMS_CODE in", values, "smsCode");
            return (Criteria) this;
        }

        public Criteria andSmsCodeNotIn(List<String> values) {
            addCriterion("SMS_CODE not in", values, "smsCode");
            return (Criteria) this;
        }

        public Criteria andSmsCodeBetween(String value1, String value2) {
            addCriterion("SMS_CODE between", value1, value2, "smsCode");
            return (Criteria) this;
        }

        public Criteria andSmsCodeNotBetween(String value1, String value2) {
            addCriterion("SMS_CODE not between", value1, value2, "smsCode");
            return (Criteria) this;
        }

        public Criteria andSmsChannelCatIsNull() {
            addCriterion("SMS_CHANNEL_CAT is null");
            return (Criteria) this;
        }

        public Criteria andSmsChannelCatIsNotNull() {
            addCriterion("SMS_CHANNEL_CAT is not null");
            return (Criteria) this;
        }

        public Criteria andSmsChannelCatEqualTo(String value) {
            addCriterion("SMS_CHANNEL_CAT =", value, "smsChannelCat");
            return (Criteria) this;
        }

        public Criteria andSmsChannelCatNotEqualTo(String value) {
            addCriterion("SMS_CHANNEL_CAT <>", value, "smsChannelCat");
            return (Criteria) this;
        }

        public Criteria andSmsChannelCatGreaterThan(String value) {
            addCriterion("SMS_CHANNEL_CAT >", value, "smsChannelCat");
            return (Criteria) this;
        }

        public Criteria andSmsChannelCatGreaterThanOrEqualTo(String value) {
            addCriterion("SMS_CHANNEL_CAT >=", value, "smsChannelCat");
            return (Criteria) this;
        }

        public Criteria andSmsChannelCatLessThan(String value) {
            addCriterion("SMS_CHANNEL_CAT <", value, "smsChannelCat");
            return (Criteria) this;
        }

        public Criteria andSmsChannelCatLessThanOrEqualTo(String value) {
            addCriterion("SMS_CHANNEL_CAT <=", value, "smsChannelCat");
            return (Criteria) this;
        }

        public Criteria andSmsChannelCatLike(String value) {
            addCriterion("SMS_CHANNEL_CAT like", value, "smsChannelCat");
            return (Criteria) this;
        }

        public Criteria andSmsChannelCatNotLike(String value) {
            addCriterion("SMS_CHANNEL_CAT not like", value, "smsChannelCat");
            return (Criteria) this;
        }

        public Criteria andSmsChannelCatIn(List<String> values) {
            addCriterion("SMS_CHANNEL_CAT in", values, "smsChannelCat");
            return (Criteria) this;
        }

        public Criteria andSmsChannelCatNotIn(List<String> values) {
            addCriterion("SMS_CHANNEL_CAT not in", values, "smsChannelCat");
            return (Criteria) this;
        }

        public Criteria andSmsChannelCatBetween(String value1, String value2) {
            addCriterion("SMS_CHANNEL_CAT between", value1, value2, "smsChannelCat");
            return (Criteria) this;
        }

        public Criteria andSmsChannelCatNotBetween(String value1, String value2) {
            addCriterion("SMS_CHANNEL_CAT not between", value1, value2, "smsChannelCat");
            return (Criteria) this;
        }

        public Criteria andSmsChannelIdIsNull() {
            addCriterion("SMS_CHANNEL_ID is null");
            return (Criteria) this;
        }

        public Criteria andSmsChannelIdIsNotNull() {
            addCriterion("SMS_CHANNEL_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSmsChannelIdEqualTo(String value) {
            addCriterion("SMS_CHANNEL_ID =", value, "smsChannelId");
            return (Criteria) this;
        }

        public Criteria andSmsChannelIdNotEqualTo(String value) {
            addCriterion("SMS_CHANNEL_ID <>", value, "smsChannelId");
            return (Criteria) this;
        }

        public Criteria andSmsChannelIdGreaterThan(String value) {
            addCriterion("SMS_CHANNEL_ID >", value, "smsChannelId");
            return (Criteria) this;
        }

        public Criteria andSmsChannelIdGreaterThanOrEqualTo(String value) {
            addCriterion("SMS_CHANNEL_ID >=", value, "smsChannelId");
            return (Criteria) this;
        }

        public Criteria andSmsChannelIdLessThan(String value) {
            addCriterion("SMS_CHANNEL_ID <", value, "smsChannelId");
            return (Criteria) this;
        }

        public Criteria andSmsChannelIdLessThanOrEqualTo(String value) {
            addCriterion("SMS_CHANNEL_ID <=", value, "smsChannelId");
            return (Criteria) this;
        }

        public Criteria andSmsChannelIdLike(String value) {
            addCriterion("SMS_CHANNEL_ID like", value, "smsChannelId");
            return (Criteria) this;
        }

        public Criteria andSmsChannelIdNotLike(String value) {
            addCriterion("SMS_CHANNEL_ID not like", value, "smsChannelId");
            return (Criteria) this;
        }

        public Criteria andSmsChannelIdIn(List<String> values) {
            addCriterion("SMS_CHANNEL_ID in", values, "smsChannelId");
            return (Criteria) this;
        }

        public Criteria andSmsChannelIdNotIn(List<String> values) {
            addCriterion("SMS_CHANNEL_ID not in", values, "smsChannelId");
            return (Criteria) this;
        }

        public Criteria andSmsChannelIdBetween(String value1, String value2) {
            addCriterion("SMS_CHANNEL_ID between", value1, value2, "smsChannelId");
            return (Criteria) this;
        }

        public Criteria andSmsChannelIdNotBetween(String value1, String value2) {
            addCriterion("SMS_CHANNEL_ID not between", value1, value2, "smsChannelId");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("STATUS is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("STATUS =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("STATUS <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("STATUS >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("STATUS >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("STATUS <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("STATUS <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("STATUS like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("STATUS not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("STATUS in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("STATUS not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("STATUS between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("STATUS not between", value1, value2, "status");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table TBL_SMS_ROUTE
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table TBL_SMS_ROUTE
     *
     * @mbggenerated
     */
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