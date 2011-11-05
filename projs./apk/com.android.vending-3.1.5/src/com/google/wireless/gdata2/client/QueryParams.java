package com.google.wireless.gdata2.client;


public abstract class QueryParams {

   public static final String ALT_JSON = "json";
   public static final String ALT_PARAM = "alt";
   public static final String ALT_RSS = "rss";
   public static final String AUTHOR_PARAM = "author";
   public static final String FIELDS_PARAM = "fields";
   public static final String MAX_RESULTS_PARAM = "max-results";
   public static final String ORDERBY_LASTMODIFIED = "lastmodified";
   public static final String ORDERBY_PARAM = "orderby";
   public static final String PUBLISHED_MAX_PARAM = "published-max";
   public static final String PUBLISHED_MIN_PARAM = "published-min";
   public static final String QUERY_PARAM = "q";
   public static final String REQUIREALLDELETED_PARAM = "requirealldeleted";
   public static final String SHOWDELETED_PARAM = "showdeleted";
   public static final String SORTORDER_ASCENDING = "ascending";
   public static final String SORTORDER_DESCENDING = "descending";
   public static final String SORTORDER_PARAM = "sortorder";
   public static final String START_INDEX_PARAM = "start-index";
   public static final String START_MAX_PARAM = "start-max";
   public static final String START_MIN_PARAM = "start-min";
   public static final String UPDATED_MAX_PARAM = "updated-max";
   public static final String UPDATED_MIN_PARAM = "updated-min";
   private String entryId;


   public QueryParams() {}

   public abstract void clear();

   public abstract String generateQueryUrl(String var1);

   public String getAlt() {
      return this.getParamValue("alt");
   }

   public String getAuthor() {
      return this.getParamValue("author");
   }

   public String getEntryId() {
      return this.entryId;
   }

   public String getFields() {
      return this.getParamValue("fields");
   }

   public int getMaxResults() {
      return Integer.parseInt(this.getParamValue("max-results"));
   }

   public abstract String getParamValue(String var1);

   public String getPublishedMax() {
      return this.getParamValue("published-max");
   }

   public String getPublishedMin() {
      return this.getParamValue("published-min");
   }

   public String getQuery() {
      return this.getParamValue("q");
   }

   public int getStartIndex() {
      return Integer.parseInt(this.getParamValue("start-index"));
   }

   public String getUpdatedMax() {
      return this.getParamValue("updated-max");
   }

   public String getUpdatedMin() {
      return this.getParamValue("updated-min");
   }

   public void setAlt(String var1) {
      this.setParamValue("alt", var1);
   }

   public void setAuthor(String var1) {
      this.setParamValue("author", var1);
   }

   public void setEntryId(String var1) {
      this.entryId = var1;
   }

   public void setFields(String var1) {
      this.setParamValue("fields", var1);
   }

   public void setMaxResults(int var1) {
      String var2 = String.valueOf(var1);
      this.setParamValue("max-results", var2);
   }

   public abstract void setParamValue(String var1, String var2);

   public void setPublishedMax(String var1) {
      this.setParamValue("published-max", var1);
   }

   public void setPublishedMin(String var1) {
      this.setParamValue("published-min", var1);
   }

   public void setQuery(String var1) {
      this.setParamValue("q", var1);
   }

   public void setStartIndex(int var1) {
      String var2 = String.valueOf(var1);
      this.setParamValue("start-index", var2);
   }

   public void setUpdatedMax(String var1) {
      this.setParamValue("updated-max", var1);
   }

   public void setUpdatedMin(String var1) {
      this.setParamValue("updated-min", var1);
   }
}
