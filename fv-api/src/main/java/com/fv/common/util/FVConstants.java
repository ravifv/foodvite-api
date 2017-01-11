package com.fv.common.util;

public interface FVConstants {

	//Icomm deploy home
	String FV_DEPLOY_HOME = "fvc.deploy.home";
	
	//database schema
	String DATABASE_SCHEMA ="database.schema";
	
	// property files
	String ENVIRONEMENT_PROPERTY_FILE_NAME = "configuration.properties";
	String AWS_PROPERTY_FILE_NAME = "configuration.properties";
	String ADMIN_PROPERTY_FILE_NAME = "ICommAdmConstants.properties";
	String ADMIN_MESSAGE_FILE_NAME = "messages_en.properties";
	String BROADCAST_PROPERTY_FILE_NAME = "FrontEndSetup.properties";
	String LOG4J_PROPERTY_FILE_NAME = "log4j.properties";
	String WHITELIST_NUMBER_PROPERTY_FILE_NAME = "Numbers.properties";
	String FV_SERVER_NAME = "server1";
	
	String EVENT_PERFORMED="login";
	String MODULE_ID = "admin";
	String TRANSACTION_REF_NUMBER ="12345";
	String TRANSACTION_REF_NUMBER_LOGOUT ="12121";
	String IP_ADDRESS="10.202.2.49";
	String SEARCH_MC="searchCriteria";
	
	// HTTP Request Header Parameters
	String IV_USER = "username";
    String IV_GROUPS = "iv-groups";
    String IV_REMOTE_ADDRESS = "iv-remote-address";
    String USER_AGENT = "USER_AGENT";
    String REFERER = "Referer";
    
	// HTTP Session Attributes
	String USER_PROFILE ="USER_PROFILE";
	String REQUEST_DATA = "REQUEST_DATA";
	String REQUEST_ACTION = "ACTION";

	// HTTP Request Attributes
	String REQUEST_CONTEXT ="REQUEST_CONTEXT";
	String ADM_CONTEXT = "ADM_CONTEXT";
	String ADM_TRACE_OBJECT = "ADM_TRACE_OBJECT"; 
	String WEBSEAL_LOGOUT_URL = "WEBSEAL_LOGOUT_URL";
	String ADM_LOGON_FAILED = "ADM_LOGON_FAILED";

	// Action URLs
	String ACTION_LOGON = "/admin/login.do";
	String ACTION_LOGOUT = "/admin/logout.do";
	
	// URL pattern for Submit & Confirm actions
	String ACTION_SUBMIT_SUFFIX = "Submit.do";
	String ACTION_CONFIRM_SUFFIX = "Confirm.do";
	String ACTION_AMEND_SUFFIX = "Amend.do";
	
	String SENSITIVE_KEY_LIST = "SENSITIVE_KEY_LIST";
    String SYSTEM_CODEPAGE ="UTF-8";
	String DOMAIN_NAME_SEPARATOR ="@";
	String UNDERSCORE = "_";
	String PLUS = "+";
	String SPACE = " ";
	String SLASH = "/";
	String EMPTY_STRING = "";
	String HYPHEN = "-";

	// delimiter
	String PROPERTY_DELIMITER_START = "String[";
	String PROPERTY_DELIMITER_END = "]";
	String PROPERTY_DELIMITER_COMMA = ",";
	String PROPERTY_DELIMITER_EQUAL = "=";
	String PROPERTY_DELIMITER_PIPE = "\\|";
	
	String CSV_FILE_FIELD_LIMIT =",";
	String CSV_FILE_EXTENSION_NAME =".csv";
		
	//LOG4J Constants
	String SUBSYSTEM_LOG_ERROR = "RMB_ADM_SYSTEM_ERROR";
	String SUBSYSTEM_INTERNAL_TIMINGS = "FV.INTERNAL.TIMINGS";
	String SUBSYSTEM_SLA_TIMINGS = "RMB_ADM.SLA.TIMINGS";
		
	// Parameter Id for Server Setting
	String SS_SESSION_TIMEOUT = "SS_SESSION_TIMEOUT";
	String SS_WARNING_MESSAGE = "SS_WARNING_MESSAGE";
	String SS_ABSOLUTE_TIMEOUT = "SS_ABSOLUTE_TIMEOUT";
	String SS_MAX_CONCURRENT_USER = "SS_MAX_CONCURRENT_USER";
	String SS_ONLINE_TXN_HISTORY = "SS_ONLINE_TXN_HISTORY";

	// Parameter Id for Business Hours
	String BH_FUNDS_TRANSFER = "BH_FUNDS_TRANSFER";
	String BH_FIXED_DEPOSIT = "BH_FIXED_DEPOSIT";
	String BH_UNIT_TRUST_PURCHASE_OFFSHORE_FUNDS = "BH_UNIT_TRUST_PURCHASE_OFFSHORE_FUNDS";
	
	// Group Id in System Parameter table
	int SYSPARAM_GROUP_SS = 0;
	int SYSPARAM_GROUP_BH = 1;

	// Group Id in TNC table
	int TNC_GROUP_TNC = 0;
	int TNC_GROUP_UT = 1;
	int TNC_GROUP_SYSTAM_MAINT = 2;
	
	// Group Id in Holiday table
	int HOLIDAY_GROUP_HOLIDAY = 0;
	int HOLIDAY_GROUP_WEEKEND = 1;
	
    // Status in Temp tables
    int STATUS_PENDING_NEW = 0;
	int STATUS_PENDING_MODIFY = 1;
	int STATUS_PENDING_DELETE = 2;
	int STATUS_PENDING_PUBLISH_NEW = 3;
	int STATUS_PUBLISHING_NEW = 4;
	int STATUS_PENDING_PUBLISH_MODIFY = 5;
	int STATUS_PUBLISHING_MODIFY = 6;
	int STATUS_PENDING_PUBLISH_DELETE = 7;
	int STATUS_PUBLISHING_DELETE = 8;
	int STATUS_APPROVED_INT = 99;
	int STATUS_REJECTED_INT = 100;
	
	// Event Log Type
	int EVENT_LOG_TYPE_AUDIT = 0;
	int EVENT_LOG_TYPE_TRANSACTION = 1;
	int EVENT_LOG_TYPE_NONE = -1;
	int EVENT_TYPE_FORCE_LOGOUT = 1;
	
	// Event logging process result
    String EVENT_PROCESS_STATUS_SUCCESS="Successful";
    String EVENT_PROCESS_STATUS_FAIL="Failed";

    // RMB event
    String REPORT_MODE_ONLINE = "1";
    String REPORT_MODE_ARCHIVE = "2";
    int REPORT_LOG_TYPE_AUDIT = 0;
    int REPORT_LOG_TYPE_TRANSACTION = 1;
    		
	// Sequence Numbers
	String SEQUENCE_NUMBER_TRANSACTION_ID = "EVENT_SEQUENCE_ID";
	String SEQUENCE_NUMBER_FAQ_ID = "ADM_FAQ_ID";
	String SEQUENCE_NUMBER_BRANCH_ID = "ADM_BRANCH_ID";
	String SEQUENCE_NUMBER_INSIGHT_ID = "ADM_INSIGHT_ID";
	String SEQUENCE_NUMBER_PRIVILEGE_ID = "ADM_PRIVILEGE_ID";
	String SEQUENCE_NUMBER_DEAL_ID = "ADM_DEAL_ID";
	String SEQUENCE_NUMBER_EVENT_ID = "ADM_EVENT_ID";
	String TEMPLATE_SEQUENCE_ID = "TEMPLATE_SEQUENCE_ID";

	// default values
	String DEFAULT_MARKER_ID = "system";
	int DEFAULT_ACTIVATED = 0;
	
	// Asian Insight
	int INSIGHT_YOUTUBE_SOURCE_TYPE = 1;
	int INSIGHT_PDF_SOURCE_TYPE = 2;
	
    // language id
	String ENGLISH_LANGUAGE_ID = "ENUS";
	String CHINESE_LANGUAGE_ID = "ZHTW";
	
	// Method Names for Sorting
	String TEMP_METHOD_NAME = "getMakerLastModifiedTime";
	String METHOD_NAME = "getCheckerLastModifiedTime";

	// date & time pattern
	String DATE_PATTERN = "yyyy-MM-dd HH:mm:ss";
	String DATE_DISPLAY_FV_PATTERN = "EEE, dd MMM yyyy HH:mm:ss";
	String DATE_DISPLAY_INVITE_PATTERN = "dd MMM, hh:mm a";
	String DATE_DISPLAY_PATTERN = "dd/MM/yyyy hh:mm:ss a";
	String DATE_FV_PATTERN = "MM/dd/yyyy HH:mm:ss";
	String DATE_SIMPLE_PATTERN = "MM/dd/yyyy";
	String DATE_TIME_PATTREN = "yyyy-MM-dd HH:mm";
	String DATE_FORMAT_REPORT = "yyyyMMddHHmmss";
	String LAST_MODIFIED_TIME_PATTREN = "yyyy-MM-dd HH:mm:ss.SSS";
	String BROADCAST_DATE_PATTERN = "yyyy-MM-dd'T'HH:mm:ss.SSSz";
	int LENGTH_ADM_EVENT_SYSTEM_ID = 4;
	int LENGTH_ADM_EVENT_EVENT_ID = 20;
	int LENGTH_ADM_EVENT_TRANSACTION_ID = 20;
	int LENGTH_ADM_EVENT_USER_ID = 20;
	int LENGTH_ADM_EVENT_CLIENT_IP = 15;
	int LENGTH_ADM_EVENT_SESSION_ID = 50;
	
	int LENGTH_ADM_USER_SESSION_SYSTEM_ID = 4;
	int LENGTH_ADM_USER_SESSION_SESSION_ID = 50;
	int LENGTH_ADM_USER_SESSION_USER_ID = 32;
	
	int LENGTH_ADM_HOLIDAY_NAME = 255;
	
	int LISTSIZE=1;
	
	//DEAL Maximum Length
	int LENGTH_ADM_DEAL_TITLE_VALUE=255;
	int LENGTH_ADM_DEAL_SHORT_DESCRIPTION_VALUE=255;
	//int LENGTH_ADM_DEAL_CONTENT_VALUE=65536;
	int LENGTH_ADM_DEAL_CONTENT_VALUE=32100;
	int MAXIMUM_IMAGE_FILE_SIZE = 102400;

	// validation
	long ONE_DAY_MILLISECONDS = 86400000;
	String META_CHAR_LIST = "\"<>()[]{}~^|`?*+'\\";
	String META_CHAR_LIST_MC = "{}~^|`\\";
	String META_CHAR_LIST_TM = "{}~^|`\\";
	String DIGIT_ONLY_CHAR_LIST = "0123456789";
	String DIGIT_AND_DOT_ONLY_CHAR_LIST = "0123456789.";
	String YN_CHAR_LIST = "YN";
	String IMAGE_FILE_PATTERN = "(^[a-z0-9]+(.(png|jpg|jpeg))$)";
	String JAVA_KEY_WORD_PATTERN = "(^(abstract|assert|boolean|break|byte|case|catch|char|class|const|continue|default|do|double|else|enum|extends|final|finally|float|for|goto|if|implements|import|instanceof|int|interface|long|native|new|package|private|protected|public|return|short|static|strictfp|super|switch|synchronized|this|throw|throws|transient|try|void|volatile|while)$)";
	String URL_PATTERN = "(^(http|https)://([A-Za-z0-9_]+:{0,1}[A-Za-z0-9_]*@)?([^ \\t\\r\\n\\v\\f]+)(:[0-9]+)?(/|/([A-Za-z0-9_]#!:.?+=&%@!-/]))?)";

	 // for HTML input fields
	 String BREAK_TAG = "<BR>";
	 String BREAK_TAG_REPLACE_COMMASPACE = ", ";
	 String STRING_Y = "Y";
	 String STRING_N = "N";
	 String HTML_FIELD_TNC_VALUE = "TNC_VALUE";
	 String HTML_FIELD_DEAL_CONTENT = "GENERAL";
	 String HTML_FIELD_PRIVILEGE_HIGHLIGHTS = "GENERAL";
	 String HTML_FIELD_PRIVILEGE_TNC = "GENERAL";
	 
	 String REQUEST_ID = "requestId";
	 
	 // IComm - Start
		// Broadcast
	 public static final String SOURCE_FILE_LOCATION = "C:\\batch\\";
	 public static final String MESSAGE_TYPE_UNKNOWN = "U"; // For Unknown

	 public static final String MESSAGE_TYPE = "";
	 public static final String MESSAGE_TYPE_SMS = "S"; // For SMS
	 public static final String MESSAGE_TYPE_EMAIL = "E"; // For EMAIL

	 public static final String EMAIL = "Email";
	 public static final String SMS = "SMS";
	 public static final String UNKNOWN = "Unknown";
	 
	 public static final int INVITE_STATUS_SENT = 0 ;
	 public static final int INVITE_STATUS_SKIP = 1 ;
	 public static final int INVITE_STATUS_JOIN = 2 ;
	 public static final int INVITE_STATUS_CANCEL = 3 ;
	 public static final int INVITE_STATUS_PREORDER = 4 ;
	 public static final int INVITE_STATUS_ORDER = 5;
	 public static final int INVITE_ORDER_STATUS_CANCEL = 6;
	 public static final int INVITE_TABLE_RESERVE = 7 ;
	 
	 public static final int ORDER_ACCEPT = 8 ;
	 public static final int ORDER_REJECT = 9 ;
	 
     public static final int BROADCAST_PROCESSING_STATUS_WAITING = 0; 
     public static final int BROADCAST_PROCESSING_STATUS_PROCESSING = 1; 
     public static final int BROADCAST_PROCESSING_STATUS_PAUSED = 2; 
     public static final int BROADCAST_PROCESSING_STATUS_COMPLETED = 3; 
     public static final int BROADCAST_PROCESSING_STATUS_CANCELLED = 4;
     public static final int BROADCAST_PROCESSING_STATUS_FAILED = 6;
     
     public static final int DRAFT_STATUS = 10;
     public static final int PENDING_STATUS = 11;
     public static final int APPROVED_STATUS = 12;
     public static final int DELETED_STATUS = 13;
     

	 public static final String AM = "AM";
	 public static final String PM = "PM";

	 public static final String TRUE = "true";
	 public static final String FALSE = "false";
	 
	 public static final String STRING_YES = "yes";
	 public static final String STRING_NO = "no";
	 
	 public static final String COLON = ":";
	 
	 public static final int ZERO = 0;
	 public static final int ONE = 1;
	 public static final int TWO = 2;
		
	
	
	String COUNTRY_CODE_SG = "SG";
	String COUNTRY_CODE_HK = "HK";
	String COUNTRY_CODE_IN = "IN";
	String COUNTRY = "COUNTRY";
	
	String TIMEZONE_CODE_SG = "Singapore";
	String TIMEZONE_CODE_HK = "Hongkong";
	String TIMEZONE_CODE_IN = "Asia/Kolkata";
	String GMT = "GMT";
	
	public static final String PROP_SMTP_HOST = "emailSender.smtp.host";
	public static final String PROP_SMTP_PORT = "emailSender.smtp.port";
	public static final String PROP_SMTP_CONNECTION_TIMEOUT = "emailSender.smtp.connectionTimeout";
	public static final String PROP_SMTP_AUTHENTICATION_REQUIRED = "emailSender.smtp.authentication.required";
	public static final String PROP_SMTP_SSL_ENABLED = "emailSender.smtp.ssl.enabled";
	public static final String PROP_SMTP_UID = "emailSender.smtp.authentication.userId";
	public static final String PROP_SMTP_PASSWORD = "emailSender.smtp.authentication.password";
	public static final String PROP_SMTP_SESSION_DEBUG_MODE = "emailSender.smtp.session.debugMode";
	public static final String EMAIL_ALERT_SENDER = "EMAIL_ALERT_SENDER";
	
	String QUEUE_MANAGER_1 = "queuemanager1";
	String QUEUE_MANAGER_2 = "queuemanager2";
	String RESPONSE_CODE = "RESPONSE_CODE";
	String RESPONSE_MSG = "RESPONSE_MSG";
	String INVALID_STATUS = "I";
	String PENDING_STATUS_P = "P";
	String VALID_STATUS = "V";
	String NDR_MSG_TOKEN_ZERO="0";
	String NDR_MSG_TOKEN_ONE="1";
	String NDR_MSG_TOKEN_TWO="2";
	String NDR_MSG_TOKEN_THREE="3";
	
	String SIT_WEBSEAL_JUNCTION_PATH_TEMP_SG="https://www1.sit1bank.dbs.com:444/icomm-sit/sg/";
	String SIT_WEBSEAL_JUNCTION_PATH_TEMP_HK="https://www1.sit1bank.dbs.com:444/icomm-sit/hk/";
	String SIT_WEBSEAL_JUNCTION_PATH_TEMP_IN="https://www1.sit1bank.dbs.com:444/icomm-sit/in/";
	
	
    String UAT_WEBSEAL_JUNCTION_PATH_TEMP_SG="https://www1.sit1bank.dbs.com:444/icomm/sg/";
	String UAT_WEBSEAL_JUNCTION_PATH_TEMP_HK="https://www1.sit1bank.dbs.com:444/icomm/hk/";
	String UAT_WEBSEAL_JUNCTION_PATH_TEMP_IN="https://www1.sit1bank.dbs.com:444/icomm/in/";
	
	String LIVE_WEBSEAL_JUNCTION_PATH_TEMP_SG="https://www1.1bank.dbs.com:444/icomm/";
	String LIVE_WEBSEAL_JUNCTION_PATH_TEMP_HK="https://www1.1bank.dbs.com:444/icomm/";
	String LIVE_WEBSEAL_JUNCTION_PATH_TEMP_IN="https://www1.1bank.dbs.com:444/icomm/";
	
	String ENVIRONMENT="WebSeal_Environment";
	String SIT="SIT";
	String UAT="UAT";
	String LIVE="LIVE";
	
	String CATEGORY_NAMES="categoryNames";
	String APIKEY = "apiKey";
	String CUSTOMER_EMAIL = "emailId";
	String COUNTRY_CODE = "countryCode";
	String MOBILE_NUMBER = "mobileNumber";
	String DEVICE_TYPE = "deviceType";
	
	String DEVICE_TOKEN = "deviceToken";

	String RESP_RECIEVED_TEXT = "RESPONSE RECEIVED";
	String RESPS_RECIEVED_TEXT = "RESPONSES RECEIVED";
	String HR_TIME_TEXT = "HOUR TO RESPOND";
	String HRS_TIME_TEXT = "HOURS TO RESPOND";
	String MINS_TIME_TEXT = "MINS TO RESPOND";
	String MIN_TIME_TEXT = "MIN TO RESPOND";
	String DAY_TIME_TEXT = "DAY TO RESPOND";
	String DAYS_TIME_TEXT = "DAYS TO RESPOND";
	String PROFILE_LOGO_PATH = "profile.logo.path";
	String WELCOME_EMAIL= "welcomemail";
	String EMAIL_VERFIFICATION= "emailVerification";
	String PARALLAX_PATH= "parallax.path";
	String LOGO_PATH= "logo.path";
	String PASSWORD_RECOVERY= "passwordRecovery";
	String STRIPE_IS_LIVE="Stripe.live";
	String STRIPE_KEY="stripe.key";
	String MANDRILL_KEY="mandrill.key";
	
}
