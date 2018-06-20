package com.company.core.dao;

import java.util.ArrayList;
import java.util.List;

public class TblSmsVerifyCodeDAOExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table TBL_SMS_VERIFY_CODE
     *
     * @mbggenerated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table TBL_SMS_VERIFY_CODE
     *
     * @mbggenerated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table TBL_SMS_VERIFY_CODE
     *
     * @mbggenerated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TBL_SMS_VERIFY_CODE
     *
     * @mbggenerated
     */
    public TblSmsVerifyCodeDAOExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TBL_SMS_VERIFY_CODE
     *
     * @mbggenerated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TBL_SMS_VERIFY_CODE
     *
     * @mbggenerated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TBL_SMS_VERIFY_CODE
     *
     * @mbggenerated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TBL_SMS_VERIFY_CODE
     *
     * @mbggenerated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TBL_SMS_VERIFY_CODE
     *
     * @mbggenerated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TBL_SMS_VERIFY_CODE
     *
     * @mbggenerated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TBL_SMS_VERIFY_CODE
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
     * This method corresponds to the database table TBL_SMS_VERIFY_CODE
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
     * This method corresponds to the database table TBL_SMS_VERIFY_CODE
     *
     * @mbggenerated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TBL_SMS_VERIFY_CODE
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
     * This class corresponds to the database table TBL_SMS_VERIFY_CODE
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

        public Criteria andPhoneNumberIsNull() {
            addCriterion("PHONE_NUMBER is null");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberIsNotNull() {
            addCriterion("PHONE_NUMBER is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberEqualTo(String value) {
            addCriterion("PHONE_NUMBER =", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberNotEqualTo(String value) {
            addCriterion("PHONE_NUMBER <>", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberGreaterThan(String value) {
            addCriterion("PHONE_NUMBER >", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberGreaterThanOrEqualTo(String value) {
            addCriterion("PHONE_NUMBER >=", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberLessThan(String value) {
            addCriterion("PHONE_NUMBER <", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberLessThanOrEqualTo(String value) {
            addCriterion("PHONE_NUMBER <=", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberLike(String value) {
            addCriterion("PHONE_NUMBER like", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberNotLike(String value) {
            addCriterion("PHONE_NUMBER not like", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberIn(List<String> values) {
            addCriterion("PHONE_NUMBER in", values, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberNotIn(List<String> values) {
            addCriterion("PHONE_NUMBER not in", values, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberBetween(String value1, String value2) {
            addCriterion("PHONE_NUMBER between", value1, value2, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberNotBetween(String value1, String value2) {
            addCriterion("PHONE_NUMBER not between", value1, value2, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andVerifyCodeIsNull() {
            addCriterion("VERIFY_CODE is null");
            return (Criteria) this;
        }

        public Criteria andVerifyCodeIsNotNull() {
            addCriterion("VERIFY_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andVerifyCodeEqualTo(String value) {
            addCriterion("VERIFY_CODE =", value, "verifyCode");
            return (Criteria) this;
        }

        public Criteria andVerifyCodeNotEqualTo(String value) {
            addCriterion("VERIFY_CODE <>", value, "verifyCode");
            return (Criteria) this;
        }

        public Criteria andVerifyCodeGreaterThan(String value) {
            addCriterion("VERIFY_CODE >", value, "verifyCode");
            return (Criteria) this;
        }

        public Criteria andVerifyCodeGreaterThanOrEqualTo(String value) {
            addCriterion("VERIFY_CODE >=", value, "verifyCode");
            return (Criteria) this;
        }

        public Criteria andVerifyCodeLessThan(String value) {
            addCriterion("VERIFY_CODE <", value, "verifyCode");
            return (Criteria) this;
        }

        public Criteria andVerifyCodeLessThanOrEqualTo(String value) {
            addCriterion("VERIFY_CODE <=", value, "verifyCode");
            return (Criteria) this;
        }

        public Criteria andVerifyCodeLike(String value) {
            addCriterion("VERIFY_CODE like", value, "verifyCode");
            return (Criteria) this;
        }

        public Criteria andVerifyCodeNotLike(String value) {
            addCriterion("VERIFY_CODE not like", value, "verifyCode");
            return (Criteria) this;
        }

        public Criteria andVerifyCodeIn(List<String> values) {
            addCriterion("VERIFY_CODE in", values, "verifyCode");
            return (Criteria) this;
        }

        public Criteria andVerifyCodeNotIn(List<String> values) {
            addCriterion("VERIFY_CODE not in", values, "verifyCode");
            return (Criteria) this;
        }

        public Criteria andVerifyCodeBetween(String value1, String value2) {
            addCriterion("VERIFY_CODE between", value1, value2, "verifyCode");
            return (Criteria) this;
        }

        public Criteria andVerifyCodeNotBetween(String value1, String value2) {
            addCriterion("VERIFY_CODE not between", value1, value2, "verifyCode");
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

        public Criteria andSendDateTimeIsNull() {
            addCriterion("SEND_DATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andSendDateTimeIsNotNull() {
            addCriterion("SEND_DATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andSendDateTimeEqualTo(String value) {
            addCriterion("SEND_DATE_TIME =", value, "sendDateTime");
            return (Criteria) this;
        }

        public Criteria andSendDateTimeNotEqualTo(String value) {
            addCriterion("SEND_DATE_TIME <>", value, "sendDateTime");
            return (Criteria) this;
        }

        public Criteria andSendDateTimeGreaterThan(String value) {
            addCriterion("SEND_DATE_TIME >", value, "sendDateTime");
            return (Criteria) this;
        }

        public Criteria andSendDateTimeGreaterThanOrEqualTo(String value) {
            addCriterion("SEND_DATE_TIME >=", value, "sendDateTime");
            return (Criteria) this;
        }

        public Criteria andSendDateTimeLessThan(String value) {
            addCriterion("SEND_DATE_TIME <", value, "sendDateTime");
            return (Criteria) this;
        }

        public Criteria andSendDateTimeLessThanOrEqualTo(String value) {
            addCriterion("SEND_DATE_TIME <=", value, "sendDateTime");
            return (Criteria) this;
        }

        public Criteria andSendDateTimeLike(String value) {
            addCriterion("SEND_DATE_TIME like", value, "sendDateTime");
            return (Criteria) this;
        }

        public Criteria andSendDateTimeNotLike(String value) {
            addCriterion("SEND_DATE_TIME not like", value, "sendDateTime");
            return (Criteria) this;
        }

        public Criteria andSendDateTimeIn(List<String> values) {
            addCriterion("SEND_DATE_TIME in", values, "sendDateTime");
            return (Criteria) this;
        }

        public Criteria andSendDateTimeNotIn(List<String> values) {
            addCriterion("SEND_DATE_TIME not in", values, "sendDateTime");
            return (Criteria) this;
        }

        public Criteria andSendDateTimeBetween(String value1, String value2) {
            addCriterion("SEND_DATE_TIME between", value1, value2, "sendDateTime");
            return (Criteria) this;
        }

        public Criteria andSendDateTimeNotBetween(String value1, String value2) {
            addCriterion("SEND_DATE_TIME not between", value1, value2, "sendDateTime");
            return (Criteria) this;
        }

        public Criteria andExpireDateTimeIsNull() {
            addCriterion("EXPIRE_DATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andExpireDateTimeIsNotNull() {
            addCriterion("EXPIRE_DATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andExpireDateTimeEqualTo(String value) {
            addCriterion("EXPIRE_DATE_TIME =", value, "expireDateTime");
            return (Criteria) this;
        }

        public Criteria andExpireDateTimeNotEqualTo(String value) {
            addCriterion("EXPIRE_DATE_TIME <>", value, "expireDateTime");
            return (Criteria) this;
        }

        public Criteria andExpireDateTimeGreaterThan(String value) {
            addCriterion("EXPIRE_DATE_TIME >", value, "expireDateTime");
            return (Criteria) this;
        }

        public Criteria andExpireDateTimeGreaterThanOrEqualTo(String value) {
            addCriterion("EXPIRE_DATE_TIME >=", value, "expireDateTime");
            return (Criteria) this;
        }

        public Criteria andExpireDateTimeLessThan(String value) {
            addCriterion("EXPIRE_DATE_TIME <", value, "expireDateTime");
            return (Criteria) this;
        }

        public Criteria andExpireDateTimeLessThanOrEqualTo(String value) {
            addCriterion("EXPIRE_DATE_TIME <=", value, "expireDateTime");
            return (Criteria) this;
        }

        public Criteria andExpireDateTimeLike(String value) {
            addCriterion("EXPIRE_DATE_TIME like", value, "expireDateTime");
            return (Criteria) this;
        }

        public Criteria andExpireDateTimeNotLike(String value) {
            addCriterion("EXPIRE_DATE_TIME not like", value, "expireDateTime");
            return (Criteria) this;
        }

        public Criteria andExpireDateTimeIn(List<String> values) {
            addCriterion("EXPIRE_DATE_TIME in", values, "expireDateTime");
            return (Criteria) this;
        }

        public Criteria andExpireDateTimeNotIn(List<String> values) {
            addCriterion("EXPIRE_DATE_TIME not in", values, "expireDateTime");
            return (Criteria) this;
        }

        public Criteria andExpireDateTimeBetween(String value1, String value2) {
            addCriterion("EXPIRE_DATE_TIME between", value1, value2, "expireDateTime");
            return (Criteria) this;
        }

        public Criteria andExpireDateTimeNotBetween(String value1, String value2) {
            addCriterion("EXPIRE_DATE_TIME not between", value1, value2, "expireDateTime");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table TBL_SMS_VERIFY_CODE
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
     * This class corresponds to the database table TBL_SMS_VERIFY_CODE
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