package com.fht.common.constant;

public interface CommonConstant {

    interface ROOM_FUNCTION {
        /**0-自用*/
        int SELF_USE = 0;
        /**1-出租*/
        int RENT = 1;
        /**2-空房（-）*/
        int EMPTY = 2;
    }

    /**
     * 是否存在电表
     */
    interface ISEXISTAMMETER {
        /**1-存在*/
        int YES = 1;
        /**2-不存在*/
        int NO = 2;
    }

    /**
     * 是否支持自动生成密码
     */
    interface SUPPORTMANUALLYGENERATE {
        /**1-支持*/
        int YES = 1;
        /**2-不支持*/
        int NO = 2;
    }

    /**
     * 紧急密码有效期
     */
    interface PASSWORDVALIDITY {
        /**果加-24*/
        int GJ = 24;
        /**云柚-2*/
        int YY = 2;
        /**丁丁-1*/
        int DD = 1;
        /**科技侠-24*/
        int SC = 24;
    }

    /**
     * 密码状态
     */
    interface PASSWORDSTATUS {
        /**0-添加失败*/
        int FAIL_TO_ADD = 0;
        /**1-添加中*/
        int ADDING = 1;
        /**2-删除中*/
        int REMOVING = 2;
        /**3-生效*/
        int TAKE_EFFECT = 3;
        /**4-未生效*/
        int INEFFECTIVE = 4;
        /**5-已失效*/
        int EXPIRED = 5;
        /**6-删除成功*/
        int REMOVE_SUCCESSFULLY = 6;
        /**7-删除失败*/
        int REMOVE_FAILED = 7;
    }

    /**
     * 生成密码
     */
    interface AUTOCREATE {
        /**手动生成*/
        int MANUALLY = 1;
        /**自动生成*/
        int AUTO = 2;
    }

    /**
     * 设备关联位置类型：1-楼幢，2-楼层，3-房间，4-房屋大门
     */
    interface RELATEPOSITIONTYPE {
        /**1-楼幢*/
        int BUILDING = 1;
        /**2-楼层 */
        int FLOOR = 2;
        /**3-房间*/
        int ROOM = 3;
        /**4-房屋大门 */
        int HOUSE = 4;
    }

    /**
     * 设备密码类型
     */
    interface PASSWORDTYPE {
        /** 1-时效密码*/
        int AGINGPASSWORD = 1;
    }

    /**
     * 是否删除：0-否，1-是
     * 
     */
    interface DELETE {
        /** 1-是 */
        int YES = 1;
        /** 0-否 */
        int NO = 0;
    }

    /**
     * 注册来源：1-PC，2-APP
     */
    interface REGISTER_SOURSE {
        int PC = 1;
        int APP = 2;
    }

    /**
     * 用户短信通知提醒时间
     */
    interface NOTICETIME {
        /** 最大 */
        int MAX = 22;
        /** 最小 */
        int MIN = 8;
    }

    /**
     * 权限模板CODE
     */
    interface TEMPLATE_CODE {
        /** PERSONAL-个人标准模板 */
        String PERSONAL = "PERSONAL";

        /** ORG-企业标准模板 */
        String ORG = "ORG";
    }

    /**
     * 状态：1-启用，2-停用
     */
    interface SWITCH_STATUS {

        /**
         * 启用
         */
        int ON = 1;
        /**
         * 停用
         */
        int OFF = 2;
    }

    /**
     * 客户短信提醒是否勾选状态：1.未勾选，2-勾选
     */
    interface IS_CHECK {
        /** 1-未勾选 */
        int NO = 1;
        /** 2-勾选 */
        int YES = 2;
    }

    /**
     * 是否默认：0-否，1-是
     */
    interface IS_DEFAULT {
        /** 0-否 */
        int NO = 0;
        /** 1-是 */
        int YES = 1;

    }

    /**
     * 性别：1-男，2-女
     */
    interface GENDER {
        /** 1-男 */
        int MALE = 1;
        /** 2-女 */
        int FEMALE = 2;
    }

    /**
     * 证件类型：1-身份证，2-护照，3-港澳通行证，4-台湾通行证
     */
    interface CARD_TYPE {
        /** 1-身份证 */
        int ID_CARD = 1;
        /** 2-护照 */
        int PASSPORT = 2;
        /** 3-港澳通行证 */
        int HK_MO_PASSPORT = 3;
        /** 4-台湾通行证 */
        int TAIWAN_PASSPORT = 4;
    }

    /**
     * 房源类型：1-集中式，2-分散式  
     */
    interface HOUSING_TYPE {
        /** 1-集中式 */
        int CONCENTRATION = 1;
        /** 2-分散式  */
        int DISTRIBUTED = 2;
    }

    /**
     * 平台模式：1-记账模式，2-线上支付模式
     */
    interface PLATFORM_TYPE {
        /** 1-记账模式 */
        int BILLING_TYPE = 1;
        /** 2-线上支付模式 */
        int ONLINE_PAY_TYPE = 2;
    }

    /**
     * 全局配置确认状态
     */
    interface CONFIRM_STATUS {
        /** 未确认 */
        int AFFIRM_NO = 1;
        /** 已确认 */
        int AFFIRM_YES = 2;
    }

    interface PAYMENT_TYPE {
        /**线上支付*/
        int ONLINE = 0;
        /**线下支付*/
        int OFFLINE = 1;
    }

    /**
     * 公寓线下支付方式： 1-现金;6-支付宝;7-微信支付;9-银行卡转账
     */
    interface PAYMENT_OFFLINE_TYPES {

        /**
         * 1,6,7,9-全部的支付方式
         */
        String ALL_PAY_WAY = "1,6,7,9";
        /**
         * 1-现金
         */
        String OFFLINE_CASH = "1";
        /**
         * 6-支付宝
         */
        String OFFLINE_ALIPAY = "6";
        /**
         * 7-微信支付
         */
        String OFFLINE_WECHAT = "7";
        /**
         * 9-银行卡转账
         */
        String BANK_CARD_TRANSFER = "9";

    }

    /**
     * 极光推送状态
     */
    interface JPUSH_STATUS {
        /** 未推送 */
        int NO_PUSH = 1;
        /** 已推送 */
        int PUSH_SUCCESS = 2;
        /** 推送失败 */
        int PUSH_FAIL = 3;
    }

    /**
     * 意见反馈来源
     */
    interface FEED_BACK_SOURCE {
        /**
         * 租房App
         */
        int MAIJIAZUFANG_APP = 1;
        /**
         * 麦滴管家App
         */
        int MAIDIGUANJIA_APP = 2;
    }
    //
    //    /**
    //     * 教育程度
    //     */
    //    interface EDU_LEVEL {
    //        /** 高中以下 */
    //        int SENIOR_SCHOOL  = 1;
    //        /** 大专 */
    //        int JUNIOR_COLLEGE = 2;
    //        /** 本科 */
    //        int UNDERGRADUATES = 3;
    //        /** 硕士 */
    //        int MASTER         = 4;
    //        /** 博士 */
    //        int DOCTOR         = 5;
    //    }
    //
    //    /**
    //     * 职业
    //     */
    //    interface PROFESSION_TYPE {
    //        /** 政府机关公务员 */
    //        int GOVERNMENT_STAFF            = 1;
    //        /** 事业单位编制内员工 */
    //        int PUBLIC_INSTITUTION_STAFF    = 2;
    //        /** 国有企业正式员工 */
    //        int STQATE_OWNED_BUSINESS_STAFF = 3;
    //        /** 民营企业管理层 */
    //        int PRIVATE_ENTERPRISE_MANAGER  = 4;
    //        /** 民营企业普通员工 */
    //        int PRIVATE_ENTERPRISE_STAFF    = 5;
    //        /** 个体工商户经营者 */
    //        int INDIVIDUAL_BUSINESS         = 6;
    //        /** 自由从业人员 */
    //        int FREELANCERS                 = 7;
    //        /** 其他 */
    //        int OTHER                       = 8;
    //        /** 无职业 */
    //        int INOCCUPATION                = 9;
    //    }
    //
    //    /**
    //     * 婚姻状态
    //     */
    //    interface MARRY_STATUS {
    //        /** 未婚 */
    //        int SINGLE   = 1;
    //        /** 已婚 */
    //        int MARRIED  = 2;
    //        /** 离异 */
    //        int DIVORCED = 3;
    //    }

    /**
     * 地区等级：1-国家，2-省，3-市，4-区/县/镇
     *
     */
    interface AREA_LEVEL {
        /** 国家 */
        int COUNTRY = 1;
        /** 省 */
        int PROVINCE = 2;
        /** 市 */
        int CITY = 3;
        /** 区/县/镇 */
        int AREA = 4;
    }

    interface DEVICE {
        /**
         * 智能设备类型
         *
         */
        interface DEVICE_TYPE {
            /** 电梯 */
            int ELEVATOR = 1;
            /** 门禁 */
            int GUARD = 2;
            /** 门锁 */
            int DOOR_LOCK = 3;
            /** 电源开关 */
            int POWER_SWITCH = 4;
            /** 水表 */
            int WATER_METER = 5;
            /** 电表 */
            int ELECTRICITY_METER = 6;
        }

        interface DEVICE_STATUS {
            /**等待安装*/
            int WAIT_INSTALL = 0;
            /**可用*/
            int ON = 1;
            /**停用*/
            int OFF = 2;
        }

        interface DEVICE_ONLINE {
            /**离线*/
            int OFF_LINE = 0;
            /**在线*/
            int ON_LINE = 1;
            /**暂不支持*/
            int NOT_SUPPORT = 2;
        }

        //设备权限可用状态
        interface DEVICE_AUTH_STATUS {
            /**可用*/
            int ON = 1;
            /**停用*/
            int OFF = 2;
        }

        //设备目前状态
        interface DEVICE_CURRENT_STATUS {
            /**在线*/
            int ON = 1;
            /**离线*/
            int OFF = 2;
        }

        /**
         * 智能设备位置类型
         */
        interface DEVICE_POSITION_TYPE {
            /** 小区*/
            int ESTATE = 1;
            /** 楼层 */
            int FLOOR = 2;
            /** 房间 */
            int ROOM = 3;
            /** 房屋大门*/
            int HOUESE = 4;
        }

        /**
         * 门禁权限可用状态
         */
        interface LODGER_STATUS {
            /**可用*/
            int ON = 1;
            /**停用*/
            int OFF = 2;
        }

        /**
         * 0-添加失败 1-添加中...  2-删除中...  3- 生效  4-未生效 5-已失效  6- 删除成功  7- 删除失败'
         * 智能密码状态
         */
        interface DEVICE_PASSWORD_STATUS {

            /** 0-添加失败*/
            int ADD_FAILED = 0;
            /** 1-添加中*/
            int ADD_ING = 1;
            /** 2-删除中 */
            int DELETE_ING = 2;
            /** 3-生效*/
            int BE_USEFUL = 3;
            /** 4-未生效*/
            int NOT_USEFUL = 4;
            /** 5-已失效*/
            int LOSE_USEFUL = 5;
            /** 6-删除成功 */
            int DELETE_SUCCESS = 6;
            /** 7-删除失败*/
            int DELETE_FAILED = 7;
        }
    }

    /**
     * 房间的状态
     */
    interface ROOM_STATUS {
        /** 未启用租务 */
        int NOT_ONLINE = 1;
        /** 可用 */
        int ENABLED = 2;
        /** 入住 */
        int BOOKING = 3;
        /** 在住 */
        int LIVING = 4;
        /** 维修 */
        int UNDER_REPAIR = 5;
        /** 空脏 */
        int EMPTY_DIRTY = 6;
        /** 保留 */
        int RETAIN = 7;
        /** 预定 */
        int RESERVED = 8;
        /** 已出租(无租客) */
        int NO_TENANT = 9;
        /** 装修中 */
        int BEING_DECORATED = 10;
    }

    /**
     * 交租类型： 1-普通，2-磐谷分期
     */
    interface RENT_TYPE {
        /** 普通 */
        int COMMON = 1;
        /** 磐谷分期 */
        int PAN_GU_STAGING = 2;
    }

    /**
     * HMS 用户、组织、角色、资源、菜单模块、照片类型
     */
    interface HMS {

        String PANGU_ORG_CODE = "PG";

        String MAIJIA_ORG_CODE = "MJ";

        String FUHENG_ORG_CODE = "FH";

        /** 是否管理员 */
        interface USER_ADMIN {
            int YES = 1;
            int NO = 0;
        }

        /**
         * 类型：1-系统，2-公司企业，3-房东/二房东，4-个人组织
         *
         */
        //用户类型没用了吧
        @Deprecated
        interface USER_TYPE {
            /** 系统 */
            int SYSTEM_ORG = 1;
            /** 公司企业 */
            int COMPANY_ORG = 2;
            /** 个人组织 */
            int PERSONAL_ORG = 3;
        }

        /**
         * 组织机构类型：1-系统，2-公司企业，3-个人组织
         *
         */
        interface ORG_TYPE {
            /** 系统 */
            int SYSTEM_ORG = 1;
            /** 公司企业 */
            int COMPANY_ORG = 2;
            /** 个人组织 */
            int PERSONAL_ORG = 3;
        }

        /**
         * 组织审核类型：1-正常，2-禁用，3-审核中
         *
         */
        interface ORG_STATUS {
            /** 正常 */
            int NORMAL = 1;
            /** 禁用 */
            int DISABLE = 2;
            /** 审核中 */
            int AUDIT = 3;
        }

        /**
         * 数据类型：1-公寓
         */
        interface ROLE_DATA_TYPE {
            /**
             * 公寓
             */
            int ESTATE = 1;
        }

        /**
         * 类型：1-上层目录，2-左侧目录，3-左侧菜单，4-按钮
         */
        interface RESOURCE_TYPE {
            /** 上层目录 */
            int TOP_FOLDER = 1;
            /** 左侧目录 */
            int LEFT_FOLDER = 2;
            /** 左侧目录 */
            int LEFT_MENU = 3;
            /** 左侧目录 */
            int BUTTON = 4;
        }

        /**
         * 类型：1-国家, 2-省, 3-市, 4-区/县, 5-板块, 9-公寓
         *
         */
        interface USER_DATA_TYPE {

            /** 1-房屋 */
            int ROOM = 1;

            int ALL = 8;
            /** 9-公寓 */
            int ESTATE = 9;
        }

        /**
         *照片类型:1-组织营业执照照片
         */
        interface PIC_TYPE {
            /** 1-组织营业执照照片  */
            int ORGANIZATION = 1;
        }

        /** 线上合同开通状态：1-未使用，2-签名审核中，3-审核通过(已启用)，4-审核不通过  */
        interface ONLINE_CONTRACT_STATUS {
            /** 1-未使用 */
            int OFF = 1;

            /** 2-签名审核中 */
            int CHECKING = 2;

            /** 3-审核通过(已启用) */
            int PASSED = 3;

            /** 4-审核不通过 */
            int UNPASS = 4;
        }

        /**
         * 线下合同上传标记 1：已上传
         *
         */
        interface OFFLINE_CONTRACT_UPLOAD_FLAG {
            /**
             * 1:已上传
             */
            int ALREADY_UPLOAD = 1;
        }

        /** 磐谷金融托底类型：1-非托底方，2-托底方  */
        interface FINANCE_TRUSTEESHIP_TYPE {
            /** 1-非托底方 */
            int NO = 1;

            /** 2-托底方 */
            int YES = 2;
        }

        /** 用户能否管理磐谷金融房源：1-不能，2-能  */
        interface MANAGE_FINANCE_HOUSE_TYPE {
            /** 1-不能 */
            int NO = 1;

            /** 2-能 */
            int YES = 2;
        }

        /** 来源：1-百度，2-系统自动生成，3-推送，4-百度手工选择，5-用户  */
        interface REGION_ADDR_SOURCE {

            /** 5-用户 */
            int USER_DEFINE = 5;
        }

        /**二次确认：0-第一次，1-需要确认，2-确认覆盖，3-使用原来的数据 */
        interface REGION_ADDR_CONFIRM_STATUS {

            /** 0-第一次 */
            int FIRST = 0;
            /** 1-需要确认 */
            int NEED_CONFIRM = 1;
            /** 2-确认覆盖 */
            int USE_CURRENT = 2;
            /** 3-使用原来的数据 */
            int USE_DB = 3;
        }
    }

    /**
     * App用户模块
     */
    interface CUSTOMER {

        /**
         * 身份证绑定用户数量：5
         */
        int IDENTITY_CARD_MAX_BOUND_COUNT = 5;

        /**
         * 实名认证状态
         */
        interface AUTHENTICATION {
            /**
             * 未提交
             */
            int UNCOMMITTED = 0;
            /**
             * 审核中
             */
            int COMMITTED = 1;
            /**
             * 审核通过
             */
            int PASS = 2;
            /**
             * 审核不通过
             */
            int NOT_PASS = 3;
        }

        /**
         * 注册来源
         */
        interface REGISTER_SOURCE {
            /**
             * PC
             */
            int PC = 1;
            /**
             * APP
             */
            int APP = 2;
        }

        /**
         * 银行卡类型
         */
        interface BANK_CARD_TYPE {
            /**
             * 储蓄卡
             */
            int DEPOSIT_CARD = 1;
            /**
             * 信用卡
             */
            int CREDIT_CARD = 2;
        }

        /**
         * 实名认证的信息来源
         */
        interface IDENTITY_SOURCE_TYPE {
            /** 支付宝开放平台 */
            int ALIPAY = 1;
            /** 门店 */
            int STORE = 2;
            /** 连连 */
            int LIANLIAN = 3;
        }
    }

    /**
     * 租赁模块
     */
    interface LEASE {

        /**
         * 线下签约合同的模板地址
         */
        String OFFLINE_CONTRACT_PDF_URL = "http://mjgy-contract-online.oss-cn-hangzhou.aliyuncs.com/20170101000000999999";

        /**
         * 渠道：1-APP，2-微信，3-网站，4-门店
         */
        interface CHANNEL_TYPE {

            /** APP */
            int APP = 1;

            /** 微信 */
            int WECHAT = 2;

            /** 网站 */
            int WEBSITE = 3;

            /** 门店 */
            int ON_DOOR = 4;

            /** 管家App */
            int MANAGE_APP = 5;

        }

        /**
         * 现金还是在线支付：0-不是，1-是
         */
        interface IS_CASH_PAY {

            /** 不是 */
            int NO = 0;

            /** 是 */
            int YES = 1;
        }

        /**
         * 订单类型：1-入住，2-续租，3-换房 ,4-预定 ,5-短租(预留)
         *
         * @author Administrator
         */
        interface ORDER_TYPE {

            /** 1-入住 */
            int ORDER = 1;

            /** 2-续租 */
            int RENEW = 2;

            /** 3-换房 */
            int CHANGE_ROOM = 3;

            /** 4-预定 */
            int RESERVED = 4;

            /** 5-短租(预留) */
            int DUANZU = 5;
        }

        /**
         * 订单类型：1-增配
         */
        interface SUB_ORDER_TYPE {

            /** 增配 */
            int SUPPLEMENT = 1;

        }

        /**
         * 是否通知入住：0-否，1-是
         */
        interface ROOM_GUEST_NOTICE {
            /** 否 */
            int NOT_NOTICE = 0;
            /** 是 */
            int IS_NOTICE = 1;
        }

        /**
         * 状态 1：添加中， 2:已取消， 3:已失效, 4：添加完成
         */
        interface ROOM_GUEST_STATUS {
            /**  1：添加中 */
            int ADDING = 1;
            /**  2:已取消 */
            int CANCEL = 2;
            /**  3:已失效 */
            int FAILURE = 3;
            /**  4：添加完成 */
            int SUCCESS = 4;
        }

        /**
         * 订单状态：1-未付款，2-已付款未签约（旧的单子），3-生效，4-取消，5-申请退款，6-关闭，7-审核中，8-支付中，99-完成
         *
         */
        interface ORDER_STATUS {

            /** 1-未付款 */
            int ORDERED = 1;

            /** 2-已付款未签约（旧的单子） */
            int PAYED = 2;

            /** 3-生效 */
            int SIGNED_AND_PAYED = 3;

            /** 4-取消 */
            int CANCELED = 4;

            /** 5-申请退款 */
            int APPLY_REFUND = 5;

            /** 6-关闭 */
            int CLOSED = 6;

            /** 7-审核中 */
            int CHECKING = 7;

            /** 8-支付中 */
            int IN_PAYMENT = 8;

            /** 99-完成 */
            int FINISH = 99;
        }

        /**
         * 订单状态：1-未付款，2-已付款未签约（旧的单子），3-生效，5-申请退款，6-关闭，7-审核中，8-支付中，99-完成，21-审核通过
         *
         */
        interface ORDER_OVERALL_STATUS {

            /** 1-未付款 */
            int ORDERED = 1;

            /** 2-已付款未签约（旧的单子 */
            int PAYED = 2;

            /** 3-生效 */
            int SIGNED_AND_PAYED = 3;

            /** 5-申请退款 */
            int APPLY_REFUND = 5;

            /** 6-关闭 */
            int CLOSED = 6;

            /** 7-审核中 */
            int CHECKING = 7;

            /** 8-支付中 */
            int IN_PAYMENT = 8;

            /** 21-审核通过 */
            int CHECKED = 21;

            /** 99-完成 */
            int FINISH = 99;
        }

        /**
         * 房间综合状态：1-下单中，2-待入住，3-在住，4-搬离，5-取消
         * 
         */
        interface ROOM_OVERALL_STATUS {

            /** 1-下单中 */
            int ORDERED = 1;

            /** 2-待入住 */
            int WAITING_IN_USE = 2;

            /** 3-在住 */
            int IN_USE = 3;

            /** 4-搬离 */
            int LEAVE = 4;

            /** 5-取消 */
            int CANCELED = 5;
        }

        /**
         * 是否自用房：0-不是，1-是
         */
        interface SELF_USE {

            /** 不是自用房 */
            int IS_NOT_SELF_USE = 0;

            /** 是自用房 */
            int IS_SELF_USE = 1;
        }

        /**
         * 房间状态：0-未入住，1-在住，2-申请换房，3-申请退房，4-已搬离
         *
         * @author Administrator
         */
        interface ORDER_ROOM_STATUS {

            /** 未入住 */
            int ORDER = 0;

            /** 在住 */
            int IN_USE = 1;

            /** 申请换房 */
            int APPLY_CHANGE = 2;

            /** 申请退房 */
            int APPLY_CHECK_OUT = 3;

            /** 已搬离 */
            int LEAVE = 4;
        }

        /**
         * 操作源：1-HMS，2-APP，3-TASK
         */
        interface OPERATE_LOG_SOURCE {
            /** HMS */
            int HMS = 1;

            /** APP */
            int APP = 2;

            /** TASK */
            int TASK = 3;
        }

        /**
         * 合同类型
         */
        interface CONTRACT_TYPE {
            /** 租房 */
            int RENT_ROOM = 1;
            /** 增配 */
            int FACILITY = 2;
            /** 换房 */
            int CHANGE_ROOM = 3;
            /** 贷款 */
            int LOAN = 4;
            /** 分期合同 */
            int INSTALLMENT = 5;
        }

        /**
         * 合同状态
         */
        interface CONTRACT_STATUS {
            /** 未签 */
            int UNSIGN = 1;
            /** 已签 */
            int SIGNED = 2;
            /** 作废 */
            int INVALID = 3;
            /** 合同生成中 */
            int CREATING = 4;
        }

        /**
         * 公寓表合同签约类型
         */
        interface CONTRACT_SIGN_TYPE {
            /** 线上签约 */
            int ONLINE = 1;
            /** 线下签约 */
            int OFFLINE = 2;
        }

        /**
         * 合同表合同签约类型
         */
        interface SIGN_TYPE {
            /** 线上签约 */
            int ONLINE = 1;
            /** 线下签约 */
            int OFFLINE = 2;
        }

        /**
         * 是否是签约人1- 是，2-不是
         */
        interface IS_SIGNED_PERSONAL {
            /** 是 */
            int IS_SIGNED_PERSONAL = 1;

            /** 不是 */
            int IS_NOT_SIGNED_PERSONAL = 2;
        }

        /**
         * 订单取消方式
         */
        interface ORDER_CANCEL_TYPE {

            /** 自动取消 */
            int AUTO_CANCEL = 1;

            /** 后台主动取消 */
            int ACTIVE_CANCEL = 2;

            /** 用户主动取消 */
            int CUSTOMER_CANCEL = 3;
        }

        /**
         * 是否线下实名认证1-是，2-否
         *
         */
        interface IS_OFFLINE_IDENTIFY {
            /** 1-是 */
            int YES = 1;

            /** 2-否 */
            int NO = 2;
        }

        /**
         * E签宝上传状态：1-未上传、2-已上传  
         *
         */
        interface ESIGN_UPLOAD_STATUS {
            /** 1-未上传 */
            int NOT = 1;

            /** 2-已上传   */
            int UPLOADED = 2;
        }

        /**
         * 申请租金乐状态：1-不用审核，2-未审核，3-审核中，4-审核通过，5-审核不通过
         *
         */
        interface APPLY_ZUJINLE_STATUS {

            /** 1-不用审核 */
            int NOT_NEED_AUDIT = 1;

            /** 2-未审核 */
            int NOT_AUDIT = 2;

            /** 3-审核中 */
            int APPLY_CHANGE = 3;

            /** 4-审核通过 */
            int PASS = 4;

            /** 5-审核不通过 */
            int NOT_PASS = 5;
        }

        /**
         * 订单取消关闭类型：1-超时未付款，2-租金乐审核超时，3-租金乐审核不通过，4-租客取消，5-房东取消，6-超时未签约取消，7-预订订单超时未入住关闭
         *
         */
        interface CANCEL_CLOSE_TYPE {

            /** 1-超时未付款 */
            int TIMEOUT_PAY = 1;

            /** 2-租金乐审核超时 */
            int TIMEOUT_ZUJINLE = 2;

            /** 3-租金乐审核不通过 */
            int FAIL_ZUJINLE = 3;

            /** 4-租客取消 */
            int CANCEL_BY_ZUKE = 4;

            /** 5-房东取消 */
            int CANCEL_BY_FANGDONG = 5;

            /** 6-超时未签约取消 */
            int TIMEOUT_SIGN = 6;

            /** 7-预订订单超时未入住关闭 */
            int TIMEOUT_RESERVED = 7;
        }

        /**
         * 用户确认价格状态：1-未确认，2-已确认
         */
        interface USER_PRICE_CONFIRM_STATUS {
            /** 1-未确认 */
            int AFFIRM_NO = 1;
            /** 2-已确认 */
            int AFFIRM_YES = 2;
        }

    }

    /**
     * 账单
     */
    interface LEASE_ORDER_LOG {
        /**
         * 操作源：1-麦滴管家WEB，2-麦邻生活APP，3-定时任务，4-运营系统，5-麦滴管家APP
         */
        interface OPERATE_SOURCE {
            /** 1-麦滴管家WEB */
            int B_WEB = 1;

            /** 2-麦邻生活APP */
            int C_APP = 2;

            /** 3-定时任务 */
            int TASK = 3;

            /** 4-运营系统 */
            int MARKET = 4;

            /** 5-麦滴管家APP */
            int B_APP = 5;
        }

        /**
         * 操作人类型：1-系统，2-公寓运营商，3-租客，4-运营
         */
        interface OPERATE_USER_TYPE {
            /** 1-系统 */
            int SYSTEM = 1;

            /** 2-公寓运营商 */
            int B_USER = 2;

            /** 3-租客 */
            int C_USER = 3;

            /** 4-运营 */
            int MARKET = 4;
        }

        /**
         * 业务类型：8-账单，9-退房
         */
        interface BIZ_TYPE {
            /** 8-账单 */
            int BILL = 8;

            /** 9-退房 */
            int CHECKOUT = 9;
        }

        /**
         * 子业务类型：801.生成账单，802.撤销账单，803.账单结算，804.短信催租，805.确认退款，901.办理退房，902.编辑退房账单内容
         */
        interface SUB_BIZ_TYPE {
            /** 801.生成账单 */
            int BILL_CREATE = 801;

            /** 802.撤销账单 */
            int BILL_CANCEL = 802;

            /** 803.账单结算 */
            int BILL_PAYED = 803;

            /** 804.短信催租 */
            int BILL_SMS_REQUEST = 804;

            /** 805.确认退款 */
            int BILL_FINISH_REFUND = 805;

            /** 901.办理退房 */
            int CHECKOUT_CREATE = 901;

            /** 902.编辑退房账单内容 */
            int CHECKOUT_EDIT = 902;
        }
    }

    /**
     * 账单
     */
    interface BILL {

        /**
         * 账单类型：1-房租，2-押金，3-暖气，4-物业，5-增配，6-退款，7-其他，8-水费，9-电费，10-宽带，11-定金，12-退房，13-服务费，14-期租金，15-首期租金，16-违约金、17-赔偿款、18-停车费、19-卫生费  
         */
        interface TYPE {

            /** 1-房租 */
            int RENT = 1;

            /** 2-押金 */
            int DEPOSIT = 2;

            /** 3-暖气 */
            int ENERGY_HEATING = 3;

            /** 4-物业 */
            int PROPERTY_PROPERTY = 4;

            /** 5-增配 */
            int SUPPLEMENT = 5;

            /** 6-退款 */
            int REFUND = 6;

            /** 7-其他 */
            int OTHER = 7;

            /** 8-水费 */
            int ENERGY_WATER_RATE = 8;

            /** 9-电费 */
            int ENERGY_ENERGY_CHARGE = 9;

            /** 10-宽带(网络费) */
            int PROPERTY_BROAD_BAND = 10;

            /** 11-定金 */
            int DOWN_PAYMENT = 11;

            /** 12-退房 */
            int CHECK_OUT = 12;

            /** 13-服务费 */
            int SERVICE_CHARGE = 13;

            /** 14-期租金 */
            int PHASE_RENT = 14;

            /** 15-首期租金 */
            int FIRST_PHASE = 15;

            /** 16-违约金 */
            int PENALTY_FEE = 16;

            /** 17-赔偿款 */
            int CLAIM_FEE = 17;

            /** 18-停车费 */
            int PARKING_FEE = 18;

            /** 19-卫生费 */
            int CLEANING_FEE = 19;
        }

        interface DOWN_PAYMENT {
            /**1-是首笔*/
            int YES = 1;
            /** 0- 不是首笔*/
            int NO = 0;
        }

        /**
         * 账单子类型：1-正常退房(退房租退押金)，2-违约退房(退房租不退押金)，3-提前退房(只退押金)，4-特殊退房(押金、房租全不退)
         */
        interface SUB_TYPE {

            /** 1-正常退房(退房租退押金) */
            int NORMAL_CHECK_OUT = 1;

            /** 违约退房(退房租不退押金) */
            int BREACH_CHECK_OUT = 2;

            /**提前退房(只退押金) */
            int ADVANCED_CHECK_OUT = 3;

            /** 特殊退房(押金、房租全不退) */
            int SPECIAL_CHECK_OUT = 4;

        }

        /**
         * 状态：1-未支付，2-已支付，3-废弃，4-支付中
         *
         */
        interface PAY_STATUS {

            /** 未支付 */
            int UNPAYED = 1;

            /** 已支付 */
            int PAYED = 2;

            /** 废弃 */
            int DELETED = 3;

            /** 支付中 */
            int IN_PAYMENT = 4;
        }

        /**
         * 支付类型：1-现金、2-麦钱包、3-支付宝、4-微信、5-连连支付、6-支付宝线下、7-微信线下、8-pos机刷卡、9-银行转账、10-平台支付宝、11-平台微信、12-平台快捷支付
         *
         */
        interface PAY_METHOD_TYPE {

            /** 1-现金 */
            int CASH = 1;

            /** 2-麦钱包 */
            int MAI_WALLET = 2;

            /** 3-支付宝 */
            int ALIPAY = 3;
            /** 4-微信 */
            int WECHAT = 4;

            /** 5-连连支付 */
            int LIANLIAN = 5;

            /** 6-支付宝线下 */
            int ALIPAY_ON_DOOR = 6;

            /** 7-微信门店支付 */
            int WECHAT_ON_DOOR = 7;

            /** 8-pos机刷卡 */
            int POS_ON_DOOR = 8;

            /** 9-银行卡转账*/
            int BANK_TRANSFER = 9;

            /** 10-平台支付宝 */
            int PLATFORM_ALIPAY = 10;

            /** 11-平台微信 */
            int PLATFORM_WECHAT = 11;

            /** 12-平台快捷支付*/
            int PLATFORM_FAST_PAYMENT = 12;
        }

        /**
         * 推送状态
         */
        interface PUSH_STATUS {
            /** 未推送 */
            int NO_PUSH = 1;
            /** 已推送 */
            int ALREADY_PUSH = 2;
        }

        /**
         * 账单计划
         */
        interface SCHEDULE_STATUS {
            /** 未创建 */
            int UNPROCESSED = 0;
            /** 已处理 */
            int PROCESSED = 1;
            /** 取消 */
            int CANCEL = 2;
        }

        /**
         *收费模式（水电费专用）：1-计价模式，2-固定收费,3-退房类型时APP不展示
         */
        interface CHARGE_TYPE {
            /** 1-计价模式*/
            int VALUATION = 1;
            /** 2-固定收费*/
            int FIXED_FEE = 2;
            /** 3-退房类型时APP不展示*/
            int NOT_SHOW = 3;
        }

        /**
         * 今日催租短信次数：0-未发送，1-已发送1次
         */
        interface TODAY_MSG_TIMES {
            /** 1-已发送1次*/
            int YES = 1;
            /** 0-未发送*/
            int NO = 0;
        }
    }

    /**
     * 磐谷
     */
    interface PANGU {
        /**
         * 推送状态
         */
        interface PUSH_STATUS {
            /** 未推送 */
            int NOT_PUSH = 1;
            /** 已推送 */
            int PUSH_SUCCESS = 2;
            /** 推送失败 */
            int PUSH_FAIL = 3;
        }

        interface API_CODE {

            /** 订单已取消 */
            public String ORDER_CANCEL = "PG001";
            /** 订单状态异常 */
            public String ORDER_STATUS_ERROR = "PG002";
        }

        interface RSA_KEY {
            /** 私钥，pkcs8格式 */
            String RSA_PRIVATE = "MIICeAIBADANBgkqhkiG9w0BAQEFAASCAmIwggJeAgEAAoGBAPukOKKesW2crWBojChW9Q8TcZh4DC4cOhknJIk6uIKvJ/57R82JXIP/SZ4eQDVxpY1fOZcOIVq1530+vdpV+dXR4z+6yTwaCbTewZWV7LtgTLUPc+yp/X/m8FKMDtjTCzmUMR6/uEF6p2ABAa2FJHpR4kNR7ae8AZP9KNBqIyAHAgMBAAECgYEA3eNEfUBpOzn4NxZ43+ktVQnUFJlmRBJnuF4nfUnmAHXqUh7qhXYluc6VX3NVMsrvK+VXpray+oWDhZCZX7iH/h7k0i1aUAUEcvnkM6Pe3FCC2p5BpCgemqjJb+8/JJshnoWphAIjG+1L2rh6N56MVHQBcUdnpCKSKxhvTjoNroECQQD98HR/NcBjaArLAK+LO2Tc1bis97HStfqrVKyt+ukVcKozqmCfqVtktkHnSJAxTOyK3LwJO1L2A7NfxOXBWuuRAkEA/a7+HWEQXnR6gaf+y9Q6SdfdWiffSrr0G/WyjUv3tFyfHZSKAy246nC8jPy3OMisaemhrtSM5n9ilDx102GWFwJBAJJnR0LwInMtUMupIYwMOiJ3tXlDdOoesN6GeufzeN47jmUrHXnvkhmGWoiVdUx3JQkKKf7IjRP5Hjlgs3W+jYECQFbtdOQqU4qaTTRKlbPQuFx/XLk8+nXIFEfUbGeghXPHXTqsoJIwQ7IKCYIiQsJxeSsdxKp86P8+3U/AW/uf7+cCQQCTCkNwUEYDilya5daUVdI2zJkQZKK4Z3RhsRBgGR7uxwhOY67GKiLbdU1vKkIXvRePMCj/6mcZU/UQcc3vwqmx";
            /** 公钥 */
            String RSA_PUBLIC = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQD7pDiinrFtnK1gaIwoVvUPE3GYeAwuHDoZJySJOriCryf+e0fNiVyD/0meHkA1caWNXzmXDiFated9Pr3aVfnV0eM/usk8Ggm03sGVley7YEy1D3Psqf1/5vBSjA7Y0ws5lDEev7hBeqdgAQGthSR6UeJDUe2nvAGT/SjQaiMgBwIDAQAB";
            /** 磐谷公钥 */
            String PG_RSA_PUBLIC = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAv86BVXhBQDbFQZmAZdFdMkXuwD7Tg4iWvc+pZLHK+6JT/gd63DqokYYVblf+PQho88sNjq2ACbwRkUbH0gNIZOqz92pS9jkkKAo4Mf+zOrVhds7WfHTx4U4xXW153nqh0Bx6ZXR1OxNC6BBA/4LyC9VHsdWoVZyogyp/2mBJjkqh7W2U8DmNNO37PuLgnLBZR7bedaknLNBnnZJYs22PoYFR/WA7N4uD/e9VkECbd71P4EAg0AFpFfpMesV74rYfc8XYzocHqRifah+r6kVplP31MmqqyqDXILo2fPdHFhffB+3m8M0cBEn8+7FTDf9h1p3tZHLqhe4cgiMpkAuS6QIDAQAB";
        }

        interface SEND_PANGU_SIGN {
            /** 未通知 */
            int NOT_SEND = 1;
            /** 已通知 */
            int SEND_SUCCESS = 2;
            /** 通知失败 */
            int SEND_FAIL = 3;
        }

        interface RET_CODE {
            /** 成功 */
            String SUCCESS = "00000000";
        }

        interface ZU_JIN_LE_STATUS {

            /**
             * 未还款
             */
            String NOT_REPAY = "00";
            /**
             * 已还款
             */
            String HAS_REPAID = "80";
        }

        interface ZU_JIN_LE_REPAY_TYPE {
            /**
             * 磐谷代扣
             */
            int PANGU_WITHHOLD = 1;
            /**
             * 提前还款
             */
            int PREPAY = 2;
        }

        interface PRODUCT_TYPE {
            /** 租金乐 */
            int ZU_JIN_LE = 1;
        }

        interface AUDIT_STATUS {
            /** 审核中 */
            int CHECK = 1;
            /** 审核通过 */
            int PASS = 2;
            /** 审核不通过 */
            int NOT_PASS = 3;
            /** 无需审核 */
            int WITHOUT_AUDIT = 4;
        }

        interface SIGN_STATUS {
            /** 未签约 */
            int NO_SIGN = 1;
            /** 已签约 */
            int SIGNED = 2;
        }

        interface TASK_TYPE {
            /** 租金乐提前还款 */
            int ZJL_REPAY = 1;
            /** 租客租金乐退租 */
            int ZJL_ROOM_CHECK_OUT = 2;
            /** 租客首笔已支付 */
            int ZJL_FIRST_PAY = 3;
        }

        interface CANCEL_ORDER_TYPE {
            int CANCEL = 1;
            int CHECK_OUT = 2;
        }

        interface PAY_EE {
            /** 房东 */
            int LANDLORD = 1;
            /** 托底组织 */
            int UNDERPIN = 2;
        }

        interface ZUJINLE_SWITCH_TYPE {
            /** 组织 */
            int ORGANIZATION = 1;
            /** 房源 */
            int HOUSE = 2;
        }

    }

    interface FINANCE {

        interface FLOW_TYPE {
            /** 流入 */
            int INCOME = 1;
            /** 流出 */
            int PAYOUT = 2;
        }

        interface SOURCE_TYPE {
            /** 账单 */
            int BILL = 1;
        }

        interface PAY_TYPE {
            /** 现金 */
            int CASH = 1;
            /** 麦钱包 */
            int WALLET = 2;
            /** 支付宝 */
            int ALIPEY = 3;
            /** 微信 */
            int WECHAT = 4;
            /** 连连支付 */
            int LIANLIAN = 5;
        }
    }

    /**
     * 集中式公寓
     */
    interface ESTATE {

        /**
         * 是否和金融交租方式配置一致
         */
        interface CAN_INHERIT {
            /**
             * the can_inherit of estate
             */
            int NO = 0;

            int YES = 1;
        }

        /**
         * 是否允许托管
         */
        interface CAN_TRUSTEESHIP {
            /**
             * the CAN_TRUSTEESHIP of estate
             */
            int NO = 0;

            int YES = 1;
        }

        /**
         * 公寓展示状态
         */
        interface SHOW_STATUS {
            /**
             * the status of estate
             */
            int NOT_SHOW = 1;

            int SHOW = 2;

            int APPLYING = 3;
        }

        interface PUBLISH_STATUS {
            /**
             * the publish status of estate
             */
            int NOT_PUBLISH = 1;

            int PUBLISH = 2;

            int APPLYING = 3;
        }

        /**
         * 智能设备位置类型
         */
        interface DEVICE_POSITION_TYPE {
            /** 小区*/
            int ESTATE = 0;
            /** 楼幢 */
            int BUILDING = 1;
            /** 楼层 */
            int FLOOR = 2;
            /** 房间 */
            int ROOM = 3;
        }

        /**
         * 公寓基础服务类型：1-配套服务，2-周边设施，3-门店服务
         *
         */
        interface ESTATE_BASE_SUPPORT_TYPE {

            /** 1-配套服务 */
            int SUPPORT_SERVICE = 1;

            /** 2-周边设施 */
            int SURROUNDINGS_SERVICE = 2;

            /** 3-门店服务 */
            int STORE_SERVICE = 3;
        }

        /**
         * 增配类型：1-洗衣机，2-冰箱，3-电视
         */
        interface FACILITY_TYPE {

            /** 洗衣机 */
            int WASHER = 1;

            /** 冰箱 */
            int FRIDGE = 2;

            /** 电视 */
            int TELEVITION = 3;

        }

        /**
         * 公寓收租方式：1-入住日提前固定天数，2-每月两次
         */
        interface ESTATE_RENT_WAY {
            /**
             * 1-入住日提前固定天数
             */
            int FIXED_DAYS_AHEAD = 1;
            /**
             * 2-每月两次
             */
            int TWO_EVERY_MONTH = 2;
        }

        /**
         * 公寓线下支付方式： 1-现金；2-支付宝，3-微信支付
         */
        interface PAYMENT_OFFLINE_TYPES {
            /**
             * 1-现金
             */
            String OFFLINE_CASH = "1";
            /**
             * 2-支付宝
             */
            String OFFLINE_ALIPAY = "2";
            /**
             * 3-微信支付
             */
            String OFFLINE_WECHAT = "3";
        }

        /**
         * 金融类型：1-非磐谷金融，2-磐谷金融，3-磐古金融申请中
         */
        interface HOUSE_FINANCE_TYPE {
            /**
             * 1-非磐谷金融
             */
            int COMMON = 1;
            /**
             * 2-磐谷金融
             */
            int FINANCE = 2;
            /**
             * 3-磐古金融申请中
             */
            int REQUEST = 3;
        }

        /**
         *
         * 公寓预留房间天数默认值：5天
         *
         */
        int ESTATE_KEEP_ROOM_DAYS = 5;

        /**
         *
         * 收租方式--入住日提前交租默认天数：7天
         *
         */
        int ESTATE_RENT_DAYS = 7;
        /**
         *
         * 收租方式--交租日提前3天推送：3天
         *
         */
        int ESTATE_RENT_PRESS_DAYS = 3;
        /**
         *
         * 收租方式--交租日提前3天推送时间：11:00:00
         *
         */
        String ESTATE_RENT_PRESS_TIME = "11:00:00";
        /**
        *
        * 收租方式--合同到期提前默认推送天数：15天
        *
        */
        int DUE_REMIND_DAY = 15;

    }

    /**
     * 分散式房屋
     */
    interface HOSTING {
        /**
         * 房屋出租类型
         */
        interface HOUSE_RENT_TYPE {
            /** 整租 */
            int ENTIRE_RENT = 1;
            /** 合租 */
            int JOINT_RENT = 2;
        }

        /**
         * 是否和金融交租方式配置一致
         */
        interface CAN_INHERIT {
            /**
             * the can_inherit of estate
             */
            int NO = 0;

            int YES = 1;
        }

        /**
         *房屋管理类型
         */
        interface HOUSE_MANAGE_TYPE {

            /** 自营 */
            int SUPERVISOR = 1;
            /** 托管 */
            int MANAGED = 2;
        }

        /**
         * 金融类型：1-非磐谷金融，2-磐谷金融，3-磐古金融申请中
         */
        interface HOUSE_FINANCE_TYPE {
            /**
             * 1-非磐谷金融
             */
            int COMMON = 1;
            /**
             * 2-磐谷金融
             */
            int FINANCE = 2;
            /**
             * 3-磐古金融申请中
             */
            int REQUEST = 3;
        }

        /**
         * 
         * 首期支付类型：1-线上，2-线下
         */
        interface DOWN_PAYMENT_TYPE {
            /** 
             * 1-线上
             */
            int ONLINE_PAY = 1;

            /**  
             * 2-线下
             */
            int OFFLINE_PAY = 2;
        }

        /**
         * 房子类型：1-普通房源，2-金融房源，3-代管房源，4-金融申请中房源
         */
        interface HOUSE_TYPE {
            /**
             * 1-普通房源
             */
            int COMMON_HOUSE = 1;
            /**
             * 2-金融房源
             */
            int FINANCE_HOUSE = 2;
            /**
             * 3-代管房源
             */
            int PROXIES_HOUSE = 3;
            /**
             * 4-金融申请中房源
             */
            int FINANCE_HOUSE_APPLYING = 4;
        }

        /**
         * 房屋朝向
         */
        interface HOUSE_DIRECTION {
            /** 朝南 */
            int SOUTH = 1;
            /** 朝北 */
            int NORTH = 2;
            /** 朝东 */
            int EAST = 3;
            /** 朝西 */
            int WEST = 4;
            /** 东南 */
            int SOUTHEAST = 5;
            /** 西南 */
            int SOUTHWEST = 6;
            /** 东北 */
            int NORTHEAST = 7;
            /** 西北 */
            int NORTHWEST = 8;
        }

        /**
         * 装修程度
         */
        interface HOUSE_DECORATION_DEGREE {
            /** 毛坯房 */
            int BLANK_HOUSE = 1;
            /** 简装修 */
            int SIMPLE_DECORATION = 2;
            /** 精装修 */
            int ELABORATE_DECORATION = 3;
            /** 豪华装 */
            int LUXURIOUS_DECORATION = 4;
        }

        /**
         * 房屋设施
         */
        interface HOUSE_FACILITY_ITEMS {
            /** 床 */
            int BED = 1;
            /** 洗衣机 */
            int WASHING_MACHINE = 2;
            /** 空调 */
            int AIR_CONDITION = 3;
            /** 冰箱 */
            int REFRIGERATOR = 4;
            /** 电视机 */
            int TELEVISION = 5;
            /** 宽带 */
            int WBN = 6;
            /** 沙发 */
            int SOFA = 7;
            /** 茶几 */
            int TEA_TABLE = 8;
            /** 书桌 */
            int DESK = 9;
            /** 餐桌 */
            int DINING_TABLE = 10;
            /** 独卫 */
            int INDEPENDENT_TOILET = 11;
            /** 衣柜 */
            int WARDROBE = 12;
        }

        /**
         * 房屋性质
         */
        interface HOUSE_NATURE {
            /** 自建房 */
            int SELF_BUILT_HOUSE = 1;
            /** 商品房 */
            int COMMERCIAL_HOUSE = 2;
            /** 安置房 */
            int PLACEMENT_HOUSE = 3;
            /** 其他 */
            int OTHER = 4;
        }

        /**
         * 房产类型
         */
        interface HOUSE_PROPERTY_TYPE {
            /** 住宅 */
            int RESIDENCE = 1;
            /** 商铺 */
            int SHOP = 2;
            /** 写字楼 */
            int OFFICE_BUILDING = 3;
            /** 其他 */
            int OTHER = 4;
        }

        /**
         * 房产抵押情况
         */
        interface HOUSE_MORTGAGE_TYPE {
            /** 已抵押给银行 */
            int MORTGAGED_TO_THE_BANK = 1;
            /** 已抵押给其他机构/个人 */
            int MORTGAGED_TO_THE_OTHER = 2;
            /** 未抵押 */
            int NOT_MORTGAGED = 3;
        }

        /**
         * 照片类型
         */
        interface HOUSE_PIC_TYPE {
            /** 房屋 */
            int HOUSE = 1;
            /** 房间 */
            int ROOM = 2;
            /** 房产证 */
            int PROPERTY = 3;
        }

        /**
         * 房间属性
         */
        interface ROOM_ATTRIBUTES {
            /** 独立卫生间 */
            int INDEPENDENT_TOILET = 1;
            /** 独立阳台 */
            int INDEPENDENT_BALCONY = 2;
            /** 独立厨房 */
            int INDEPENDENT_KITCHEN = 3;
            /** 带飘窗 */
            int BAY_WINDOW = 4;
        }

        /**
         * 智能设备位置类型
         */
        interface POSITION_TYPE {

            /** 大门锁 */
            int HOUSE_LOCK = 1;

            /** 房间锁 */
            int ROOM_LOCK = 2;
        }

        /**
         * 发布状态：1-未发布， 2-发布，3-申请中
         */
        interface ROOM_PUBLISH_STATUS {
            /** 未发布 */
            int UNPUBLISHED = 1;
            /** 可用 */
            int PUBLISHED = 2;
            /** 申请中 */
            int APPLYING = 3;
        }

        /**
         * 是否能使用租金乐1－能，2-不能
         */
        interface CAN_USE_FINANCE {
            /** 1－能 */
            int CAN = 1;
            /** 2-不能 */
            int CAN_NOT = 2;
        }
    }

    /**
     * 房屋
     */
    interface ROOM_COMMON {
        /**
         * 发布状态
         */
        interface PUBLISH_STATUS {
            /** 未发布 */
            int UNPUBLISHED = 1;
            /** 可用 */
            int PUBLISHED = 2;
        }
    }

    /**
     * 消息
     */
    interface MESSAGE {

        /**
         * 消息业务类型：1-换房，2-退房，3-增配
         */
        interface LEASE_TYPE {
            /** 换房 */
            int CHANGE_ROOM = 1;
            /** 退房 */
            int CHECK_OUT = 2;
            /** 增配 */
            int SUPPLEMENT = 3;
        }

        /**
         * 手机短信消息类型
         */
        interface MOBILE_SMS_TYPE {
            /** 验证码 */
            int CHECK_CODE = 1;
            /** 消息通知 */
            int MESSAGE = 2;
        }

        /**
         * 消息类别：1-官方消息，2-公寓消息，3-活动消息
         */
        interface TYPE {
            /** 官方消息 */
            int PLATFORM = 1;
            /** 公寓消息 */
            int ESTATE = 2;
            /** 活动消息 */
            int ACTIVITY = 3;
        }

        /**
         * 消息状态
         */
        interface STATUS {
            /** 未读 */
            int NOT_READ = 1;
            /** 已读 */
            int READ = 2;
        }

        /**
         * 消息处理状态：1-未处理，2-已处理
         */
        interface PROCESS_STATUS {
            /** 未处理 */
            int UNPROCESSED = 1;
            /** 已处理 */
            int PROCESSED = 2;
        }

        /**
         * 消息业务类型枚举类
         */
        interface BIZ_TYPE {
            /** 缴费 */
            String PAYMENT = "缴费";
            /** 账单 */
            String BILL = "账单";
            /** 房屋状态 */
            String ESTATE_STATUS = "房屋状态";
            /** 通知 */
            String NOTICE = "通知";
            /** 合同 */
            String CONTRACT = "合同";
            /** 订单 */
            String ORDER = "订单";
            /** 欢迎入住 */
            String WELCOME = "欢迎入住";
            /** 活动 */
            String ACTIVITY = "活动";
        }
    }

    /**
     *
     * 运营 平台
     */
    interface OPERATION {

        /**
         * 状态
         */
        interface STATUS {
            /** 1-待上线 */
            int NOT_ONLINE = 1;
            /** 2-已上线 */
            int ON_LINE = 2;
            /** 3-已下线 */
            int OFF_LINE = 3;
        }

    }

    /**
     * 通用选择（是/否）
     */
    interface YES_NO {
        /** 否 */
        int NO = 1;
        /** 是 */
        int YES = 2;
    }

    /**
     * 是否删除
     */
    interface IS_DELETE {
        /** 否 */
        int NO = 0;
        /** 是 */
        int YES = 1;
    }

    /**
     * 产权联系人表常量类参数
     */
    interface CONTACT {
        /**
         * 证件类型
         */
        interface CARD_TYPE {
            /** 身份证 */
            int ID_CARD = 1;
            /** 护照 */
            int PASSPORT = 2;
            /** 港澳通行证 */
            int HK_MACAU_PASSER = 3;
            /** 台湾通行证 */
            int TAIWAN_PASS = 4;
        }

        /**
         * 教育程度
         */
        interface EDU_LEVEL {
            /** 高中以下 */
            int SENIOR_SCHOOL = 1;
            /** 大专 */
            int JUNIOR_COLLEGE = 2;
            /** 本科 */
            int UNDERGRADUATES = 3;
            /** 硕士 */
            int MASTER = 4;
            /** 博士 */
            int DOCTOR = 5;
        }

        /**
         * 职业
         */
        interface PROFESSION_TYPE {
            /** 政府机关公务员 */
            int GOVERNMENT_STAFF = 1;
            /** 事业单位编制内员工 */
            int PUBLIC_INSTITUTION_STAFF = 2;
            /** 国有企业正式员工 */
            int STQATE_OWNED_BUSINESS_STAFF = 3;
            /** 民营企业管理层 */
            int PRIVATE_ENTERPRISE_MANAGER = 4;
            /** 民营企业普通员工 */
            int PRIVATE_ENTERPRISE_STAFF = 5;
            /** 个体工商户经营者 */
            int INDIVIDUAL_BUSINESS = 6;
            /** 自由从业人员 */
            int FREELANCERS = 7;
            /** 其他 */
            int OTHER = 8;
            /** 无职业 */
            int INOCCUPATION = 9;
        }

        /**
         * 婚姻状态
         */
        interface MARRY_STATUS {
            /** 未婚 */
            int SINGLE = 1;
            /** 已婚 */
            int MARRIED = 2;
            /** 离异 */
            int DIVORCED = 3;
        }

        /**
         * 合同模板类型：1-企业，2-个人房东，3-托底方普通，4-托底方金融
         */
        interface CONTRACT_TEMPLATE_TYPE {
            /** 1-企业 */
            int COMPANY = 1;
            /** 2-个人房东 */
            int PERSON = 2;
            /** 3-托底方普通 */
            int TRUSTEESHIP_NORMAL = 3;
            /** 4-托底方金融 */
            int TRUSTEESHIP_FINANCE = 4;
        }

        /**
         * 合同签章类型：1-企业，2-个人房东，3-托底方，4-企业+托底方，5-房东+托底方
         */
        interface CONTRACT_SIGN_SEAL_TYPE {
            /** 1-企业 */
            int COMPANY = 1;
            /** 2-个人房东 */
            int PERSON = 2;
            /** 3-托底方(合同甲方的位置) */
            int TRUSTEESHIP = 3;
            /** 4-企业+托底方 */
            int COMPANY_TRUSTEESHIP = 4;
            /** 5-房东+托底方 */
            int PERSON_TRUSTEESHIP = 5;
        }
    }

    /**
     * 分散式房源房屋常量类参数
     */
    interface HOUSE {
        /**
         * 房屋出租类型
         */
        interface HOUSE_RENT_TYPE {
            /** 整租 */
            int ENTIRE_RENT = 1;
            /** 合租 */
            int JOINT_RENT = 2;
        }

        interface HOUSE_MANAGE_TYPE {

            /** 自营 */
            int SUPERVISOR = 1;
            /** 托管 */
            int MANAGED = 2;
        }

        /**
         * 房屋朝向
         */
        interface DIRECTION {
            /** 朝南 */
            int SOUTH = 1;
            /** 朝北 */
            int NORTH = 2;
            /** 朝东 */
            int EAST = 3;
            /** 朝西 */
            int WEST = 4;
            /** 东南 */
            int SOUTHEAST = 5;
            /** 西南 */
            int SOUTHWEST = 6;
            /** 东北 */
            int NORTHEAST = 7;
            /** 西北 */
            int NORTHWEST = 8;
        }

        /**
         * 装修程度
         */
        interface DECORATION_DEGREE {
            /** 毛坯房 */
            int BLANK_HOUSE = 1;
            /** 简装修 */
            int SIMPLE_DECORATION = 2;
            /** 精装修 */
            int ELABORATE_DECORATION = 3;
            /** 豪华装 */
            int LUXURIOUS_DECORATION = 4;
        }

        /**
         * 房屋设施
         */
        interface FACILITY_ITEMS {
            /** 床 */
            int BED = 1;
            /** 洗衣机 */
            int WASHING_MACHINE = 2;
            /** 空调 */
            int AIR_CONDITION = 3;
            /** 冰箱 */
            int REFRIGERATOR = 4;
            /** 电视机 */
            int TELEVISION = 5;
            /** 宽带 */
            int WBN = 6;
            /** 沙发 */
            int SOFA = 7;
            /** 茶几 */
            int TEA_TABLE = 8;
            /** 书桌 */
            int DESK = 9;
            /** 餐桌 */
            int DINING_TABLE = 10;
            /** 独卫 */
            int INDEPENDENT_TOILET = 11;
            /** 衣柜 */
            int WARDROBE = 12;
        }

        //        /**
        //         * 磐谷审核状态
        //         */
        //        interface PANGU_CHECK_STATUS {
        //            /** 未审核 */
        //            int NOT_AUDIT = 1;
        //            /** 审核通过 */
        //            int PASS = 2;
        //            /** 审核不通过 */
        //            int NOT_PASS = 3;
        //            /** 不需要审核 */
        //            int NOT_NEED_AUDIT = 4;
        //        }
    }

    /**
     * 分散式房源房产信息常量类参数
     */
    interface HOUSE_INFO {
        /**
         * 房屋性质
         */
        interface HOUSE_NATURE {
            /** 自建房 */
            int SELF_BUILT_HOUSE = 1;
            /** 商品房 */
            int COMMERCIAL_HOUSE = 2;
            /** 安置房 */
            int PLACEMENT_HOUSE = 3;
            /** 其他 */
            int OTHER = 4;
        }

        /**
         * 房产类型
         */
        interface PROPERTY_TYPE {
            /** 住宅 */
            int RESIDENCE = 1;
            /** 商铺 */
            int SHOP = 2;
            /** 写字楼 */
            int OFFICE_BUILDING = 3;
            /** 其他 */
            int OTHER = 4;
        }

        /**
         * 房产抵押情况
         */
        interface MORTGAGE_TYPE {
            /** 已抵押给银行 */
            int MORTGAGED_TO_THE_BANK = 1;
            /** 已抵押给其他机构/个人 */
            int MORTGAGED_TO_THE_OTHER = 2;
            /** 未抵押 */
            int NOT_MORTGAGED = 3;
        }

        /**
         * 申请磐谷金融产品类型
         */
        interface FINANCIAL_PRODUCT {
            /** 房东乐 */
            int LANDLORD = 1;
            /** 收房乐 */
            int RECEIVE_HOUSE = 2;
        }

    }

    /**
     * 房源房间房产证照片常量类参数
     */
    interface PICTURE {
        /**
         * 照片类型
         */
        interface PIC_TYPE {
            /** 房间 */
            int ROOM = 1;
            /** 房产证 */
            int PROPERTY = 2;
        }

        /**
         * 集中式照片类型:1-公寓，2-房型，3-房间
         */
        interface ESTATE_PIC_TYPE {
            /** 公寓 */
            int ESTATE = 1;
            /** 房型 */
            int ROOM_TYPE = 2;
            /** 房间 */
            int ROOM = 3;
        }
    }

    /**
     * 分散式房间常量类参数
     */
    interface ROOM {

        /**
         * 房间属性
         */
        interface ROOM_ATTRIBUTES {
            /** 独立卫生间 */
            int INDEPENDENT_TOILET = 1;
            /** 独立阳台 */
            int INDEPENDENT_BALCONY = 2;
            /** 独立厨房 */
            int INDEPENDENT_KITCHEN = 3;
            /** 带飘窗 */
            int BAY_WINDOW = 4;
        }

        /**
         * 发布渠道
         */
        interface CHANNEL {
            /** 网站 */
            int WEB = 1;
            /** APP */
            int APP = 2;
            /** 微信 */
            int WECHAT = 3;
        }

        /**
         * 发布状态
         */
        interface PUBLISH_STATUS {
            /** 未发布 */
            int UNPUBLISHED = 1;
            /** 发布 */
            int PUBLISHED = 2;
        }

    }

    interface ORDER {

        /**
         * 是否是已有租客入住：1-新租客，2-已有租客录入
         * 
         * @author caojian
         */
        interface IN_STAY_CUSTOMER {
            /** 新租客 */
            int NEW_CUSTOMER = 1;

            /** 已有租客录入 */
            int IN_STAY_CUSTOMER = 2;
        }

        /**
         * 在住状态：1-未入住 ，2-在住，3-搬离，4-取消
         * 
         * @author caojian
         */
        interface HOSTING_IN_STAY_STATUS {

            /** 未入住 */
            int NOT_IN_STAY = 1;

            /** 在住 */
            int IN_STAY = 2;

            /** 搬离 */
            int LEAVE = 3;

            /** 取消 */
            int CANCELED = 4;

        }

        /**
         * 是否和金融交租方式配置一致：0-不一致，1-一致
         * 
         */
        interface RENT_CAN_INHERIT {

            /** 0-不一致 */
            int NO = 0;

            /** 1-一致 */
            int YES = 1;

        }

        /**
         * 是否允许托管
         */
        interface CAN_TRUSTEESHIP {
            /**
             * the CAN_TRUSTEESHIP of estate
             */
            int NO = 0;

            int YES = 1;
        }

    }

    interface HOSTING_DEVICE {
        /**
         * 智能设备类型
         * 
         * @author LiYishi
         */
        interface DEVICE_TYPE {
            /** 电梯 */
            int ELEVATOR = 1;
            /** 门禁 */
            int GUARD = 2;
            /** 门锁 */
            int DOOR_LOCK = 3;
            /** 电源开关 */
            int POWER_SWITCH = 4;
            /** 水表 */
            int WATER_METER = 5;
            /** 电表 */
            int ELECTRICITY_METER = 6;
        }

        /**
         * 智能设备位置类型
         * 
         * @author LiYishi
         */
        interface POSITION_TYPE {

            /** 大门锁 */
            int HOUSE_LOCK = 1;

            /** 房间锁 */
            int ROOM_LOCK = 3;
        }

        /**
         * 状态
         * 
         * @author LiYishi
         */
        interface STATUS {
            /** 启用 */
            int ENABLED = 1;
            /** 停用 */
            int DISABLED = 2;
        }
    }

    //    /**
    //     * 磐谷审核状态：1-未审核, 2-审核通过, 3-审核不通过, 4-不需要审核
    //     */
    //    interface PANGU_CHECK_STATUS {
    //        /** 1-未审核 */
    //        int UNCHECKED = 1;
    //        /** 2-审核通过 */
    //        int PASS = 2;
    //        /** 3-审核不通过 */
    //        int FAIL = 3;
    //        /** 4-不需要审核 */
    //        int NOTNEED = 4;
    //    }

    // /**
    // * 照片类型：1-房间，2-房产证
    // */
    // interface ROOM_PICTURE_TYPE {
    // /** 房间 */
    // int ROOM_PIC = 1;
    // /** 房产证 */
    // int ROOM_PROPERTY = 2;
    // }

    /**
     * 是否展示图：1-否，2-是
     */
    interface ROOM_IS_TOP_PICTURE {
        /** 否 */
        int NO = 1;
        /** 是 */
        int YES = 2;
    }

    /**
     * 民间借贷：1-无，2-有
     * 
     */
    interface CONTRACT_PRIVATE_LOAN {
        /** 无 */
        int NO = 1;
        /** 有 */
        int YES = 2;
    }

    /**
     * 房源授权表
     */
    interface HOSTING_AUTHORIZATION {

        /**
         * 授权物类型：1-分散式房屋
         */
        interface ENTUTY_TYPE {
            /** 1-分散式房屋 */
            int HOSTING_HOUSE = 1;
        }

        /**
         * 授权类型：1-查看
         */
        interface AUTHORIZATION_TYPE {

            /** 1-查看 */
            int CHECK = 1;
        }

    }

    /**
     * 客户类型：1-企业, 2-个人
     * 
     */
    interface CONTRACT_LOAN_TYPE {
        /** 1-企业 */
        int COMPANY = 1;
        /** 2-个人 */
        int PERSONAL = 2;
    }

    /**
     * 客户来源：1-自由客户, 2-地推, 3-渠道, 4-其他
     * 
     */
    interface CONTRACT_CUSTOMER_SOURCE {
        /** 1-自由客户 */
        int SOURCE1 = 1;
        /** 2-地推 */
        int SOURCE2 = 2;
        /** 3-渠道 */
        int SOURCE3 = 3;
        /** 4-其他 */
        int SOURCE4 = 4;
    }

    /**
     * 是否二手房源：1-否，2-是
     * 
     */
    interface MANAGER_IS_LANDLORD {
        /** 1-否 */
        int NO = 1;
        /** 2-是 */
        int YES = 2;
    }

    interface ROOM_RENT_TYPE {

        /**
         * 首笔收款方：1-房东，2-托管组织
         * 
         */
        interface FIRST_PAYEE {
            /** 1-房东*/
            int HOST = 1;
            /** 1-托管组织*/
            int TRUST = 2;
        }

        /**
         * 后续收款方：1-房东，2-托管组织
         * 
         */
        interface FOLLOW_PAYEE {
            /** 1-房东*/
            int HOST = 1;
            /** 1-托管组织*/
            int TRUST = 2;
        }

        /**
         * 合同签约类型：1-单签，2-双签
         * 
         */
        interface CONTRACT_SIGN_TYPE {
            /** 1-单签*/
            int SINGLE = 1;
            /** 1-双签*/
            int DOUBLE = 2;
        }

        /**
         * 单签调用合同类型：1-房东，2-托管组织
         * 
         */
        interface SINGLE_SIGN_TYPE {
            /** 1-房东*/
            int HOST = 1;
            /** 1-托管组织*/
            int TRUST = 2;
        }

        /**
         * 是否允许线下签约：0-不，1-允许
         * 
         */
        interface CAN_OFFLINE_SIGN {
            /** 1-不*/
            int NO = 0;
            /** 1-允许*/
            int YES = 1;
        }

        /**
         *  服务费计算类型：1-无，2-固定金额，3-租金百分比serviceChargeType
         *
         */
        interface SERVICE_CHARGE_TYPE {

            /** 1-无 */
            int NOT_HAVE = 1;

            /** 2-固定金额 */
            int FIXED_MONEY = 2;

            /** 3-租金百分比 */
            int RATIO = 3;
        }

        /**
         * 服务费支付方式：1-无，2-随租金付，3-一次性付清
         *
         */
        interface SERVICE_FEE_TYPE {

            /** 1-无 */
            int NOT_HAVE = 1;

            /** 2-随租金付 */
            int WITH_RENT = 2;

            /** 3-一次性付清 */
            int ALL_PAY = 3;
        }
    }

    /**
     * 云设备
     */
    interface CLOUD {

        /**
         * 操作人类型：1-系统，2-客户，3-管家
         */
        interface OPERATOR_TYPE {
            /** 1-系统 */
            int SYSTEM = 1;

            /** 2-CUSTOMER */
            int WITH_RENT = 2;

            /** 3-管家 */
            int MANAGER = 3;
        }
    }

    /**
     * 运营管理
     */
    interface MARKET {
        /**
         * token类型： 1：个人电子签名 
         */
        interface TOKEN_TYPE {
            /** 1-个人电子签名 */
            int PERSONAL_SIGNATURE = 1;
        }

        /** 
         * 状态：1-未使用，2-已经使用，3-作废  
         */
        interface TOKEN_STATUS {

            /**
             * 1-未使用
             */
            int UNUSED = 1;
            /**
             * 2-已经使用
             */
            int USED = 2;
            /**
             * 3-作废  
             */
            int CANCEL = 3;
        }

        /**
         * 审核类型： 1-个人电子签名，  2-分散式房源发布
         */
        interface REVIEW_TYPE {
            /** 1-个人电子签名 */
            int PERSONAL_SIGNATURE = 1;

            /** 2-分散式房源发布 */
            int HOSTING_ROOM_PUBLISH = 2;

            /** 3-集中式房源发布*/
            int ESTATE_ROOM_PUBLISH = 3;
        }

        /**
         * 状态：1-待审核，2-审核通过，3-审核不通过  
         */
        interface REVIEW_STATUS {
            /** 1-待审核 */
            int UNCHECK = 1;

            /** 2-审核通过 */
            int PASSED = 2;

            /** 3-审核不通过 */
            int UNPASS = 3;
        }

        /** 
         * 用户申请状态：1-未联系，2-已联系
         */
        interface USER_REQUEST_STATUS {

            /**
             * 1-未联系
             */
            int UNCONTACT = 1;
            /**
             * 2-已联系
             */
            int CONTACTED = 2;
        }

    }

    /**
     * E签宝
     */
    interface ESIGN_CONSTANT {

        /**
         * 注册类型，1-代理人注册，2-法人注册
         */
        interface ESIGN_USER_TYPE {
            /** 1-代理人注册 */
            int AGENT = 1;
            /** 2-法人注册 */
            int LEGAL = 2;
        }

        /** 
         * 企业注册类型，1-组织机构代码号，2-多证合一，传递社会信用代码号
         */
        interface ORG_REG_TYPE {

            /**
             * 1-组织机构代码号
             */
            int NORMAL = 1;
            /**
             * 2-多证合一，传递社会信用代码号
             */
            int MERGE = 2;
        }

    }

    interface AUTH {

        /**
         * 用户数据权限勾选
         * 
         * @author leixx
         * @version $Id: CommonConstant.java, v 0.1 2017年6月8日 下午3:51:52 leixx Exp $
         */
        interface USER_DATA_CHECK {
            /**
             * 未选中
             */
            int NOT_CHECK = 0;
            /**
             * 部分选中
             */
            int PART_CHECK = 1;

            /**
             * 选中
             */
            int CHECKED = 2;
        }
    }

    /**
     * 
     * 实时房态给页面的状态值：自用房 ：1
     */
    interface ROOM_STATUS_TO_PAGE {
        /** 自用房 */
        int IS_SELF_USE_ROOM = 1;
        /** 可用 */
        int ENABLED = 2;
        /** 入住 */
        int BOOKING = 3;
        /** 已出租 */
        int RENT = 4;
        /** 保留 */
        int RETAIL = 5;
    }

    /**
     * 黑白名单业务类型
     * 
     * @author Seung
     * @version $Id: CommonConstant.java, v 0.1 2017年6月28日 上午10:43:27 Seung Exp $
     */
    interface WHITE_BLACK_LIST {

        interface BIZ_TYPE {
            /**  房源发布审核 */
            int ROOM_REVIEW_CHECK = 1;
        }

    }

    /**
     * 工作台
     * @author caojian
     * @version $Id: CommonConstant.java, v 0.1 2017年7月10日 上午8:34:01 caojian Exp $
     */
    interface WORKBENCH {
        /** 页面传过来的页面类型值*/
        interface PAGE_TYPE {
            /**  1-账单*/
            int BILL = 1;

            /**  2-合同*/
            int CONTRACT = 2;

            /**  3-预订房*/
            int RESERVED = 3;

            /**  4-首笔确认付款*/
            int FIRST_PAYMENT = 4;

            /**  5-租客预约*/
            int TENANT_BOOKING = 5;

            /**  6-下单中*/
            int ORDERING = 6;
        }
    }

    /**
     * 实时房态
     */
    interface REAL_TIME_ROOM {
        /**
         * 
         * 分散式实时房态数据库查询状态条件
         */
        interface HOSTING_ROOM_STATUS_TO_DB {
            /** 全部*/
            int ALL_ROOM = 0;
            /** 在住 */
            int IS_RENT = 4;
            /** 空房 */
            int ENABLED = 2;
            /** 未缴费 */
            int UNPAY = 15;
            /** 合同将到期 */
            int EXPIRE = 17;
            /** 下单中 */
            int BOOKING = 18;
            /** 待入住*/
            int CHECK_IN = 3;
            /** 保留中 */
            int RETAIN = 7;
            /** 已出租(无租客) */
            int NO_TENANT = 9;
            /** 装修中 */
            int BEING_DECORATED = 10;
        }

        /**
         * 
         * 数据库查询状态条件
         */
        interface ESTATE_ROOM_STATUS_TO_DB {
            /** 全部*/
            int ALL_ROOM = 0;
            /** 空房 */
            int ENABLED = 2;
            /** 待入住 */
            int BOOKING = 3;
            /** 在住 */
            int LIVING = 4;
            /** 维修 */
            int UNDER_REPAIR = 5;
            /** 空脏 */
            int EMPTY_DIRTY = 6;
            /** 保留中 */
            int RETAIN = 7;
            /** 预定 */
            int RESERVED = 8;
            /** 已出租(无租客) */
            int NO_TENANT = 9;
            /** 装修中 */
            int BEING_DECORATED = 10;
            /** 未缴费 */
            int UNPAY = 15;
            /** 自用 */
            int IS_SELF_USE = 16;
            /** 合同将到期 */
            int EXPIRE = 17;
            /** 下单中 */
            int ORDERING = 18;
        }
    }

    /**
     * 房源能源配置
     *
     */
    interface FANGYUAN_ENERGY {
        /**
         * 费用类型：1-水费，2-电费，3-暖气，4-宽带，5-物业，99-其他
         */
        interface ENERGY_TYPE {

            /** 水费 */
            int ENERGY_WATER_RATE = 1;

            /** 电费 */
            int ENERGY_ENERGY_CHARGE = 2;

            /** 暖气 */
            int ENERGY_HEATING = 3;

            /** 宽带 */
            int PROPERTY_BROAD_BAND = 4;

            /** 物业 */
            int PROPERTY_PROPERTY = 5;

            /** 其他 */
            int OTHER = 99;

        }
    }

    interface FANGYUAN_OPERATE {
        /**
         * 操作源：1-HMS，2-C端APP，3-TASK，4-MARKET，5-HMSAPP，6-API
         */
        interface OPERATE_LOG_SOURCE {
            /** HMS */
            int HMS = 1;

            /** APP */
            int APP = 2;

            /** TASK */
            int TASK = 3;

            /** MARKET */
            int MARKET = 4;

            /** HMSAPP */
            int HMSAPP = 5;

            /** API */
            int API = 6;
        }
    }

    /**
     * 账单创建状态：0-未创建，1-已创建，2-取消
     */
    interface TASK_STATUS {
        /** 未创建 */
        int NO = 0;
        /** 已创建 */
        int YES = 1;
        /** 取消*/
        int CANCEL = 2;
    }

    /**
     * 是否历史订单：0-不是，1-是
     */
    interface IS_HISTORY_ORDER {
        /** 否 */
        int NO = 0;
        /** 是 */
        int YES = 1;
    }

    /**
     * 是否处理：0-未处理，1-已处理
     */
    interface IS_PROCESS {
        /** 未处理 */
        int NO = 0;
        /** 已处理 */
        int YES = 1;
    }

    /**
     * 页面房间状态（集中式）：1-全部，2-未缴费，3-空房，4-下单未入住，5-预定，6-出租，7-自用房，8-空脏房，9-维修房
     * ()
     */
    interface ROOM_STATUS_IN_PAGE {

        /** 全部 */
        int ALL_ROOM = 1;
        /** 未缴费 */
        int UNPAY_ROOM = 4;
        /** 空房 */
        int EMPTY_ROOM = 2;
        /** 待入住 */
        int ORDER_ROOM = 5;
        /** 预定 */
        int RESERVED_ROOM = 6;
        /** 出租 */
        int RENT_ROOM = 3;
        /** 自用房 */
        int SELF_USE_ROOM = 8;
        /** 空脏房 */
        int DIRTY_ROOM = 9;
        /** 维修房 */
        int MAINTAIN_ROOM = 10;
        /** 合同将到期 v20版本:15天 */
        int EXPIRE_ROOM = 7;
        /** 已出租(无租客) */
        int NO_TENANT = 11;
        /** 装修中 */
        int BEING_DECORATED = 12;
        /** 下单中 */
        int ORDERING = 13;
        /** 保留 */
        int RETAIL = 14;
    }

    /**
     * 意向客源
     */
    interface INTENTION_CUSTOMER {
        /**
         * 状态：1-跟进中，2-已入住，3-无效
         */
        interface STATUS {
            /** 1-跟进中 */
            int FOLLOWING = 1;

            /** 2-已入住 */
            int STAY_IN = 2;

            /** 3-无效 */
            int DISABLE = 3;
        }

        /**
         * 来源：1-来电, 2-自然到访, 3-宣传单页, 4-网络, 5-官网, 6-广告, 7-企业客户, 8-经纪人, 9-门店地推
         */
        interface SOURCE {
            /** 1-来电 */
            int PHONE = 1;
            /** 2-自然到访 */
            int NATURAL_VISIT = 2;
            /** 3-宣传单页 */
            int ADVERTISING_PAGE = 3;
            /** 4-网络 */
            int NETWORK = 4;
            /** 5-官网 */
            int OFFICIAL_WEBSITE = 5;
            /** 6-广告 */
            int ADVERTISING = 6;
            /** 7-企业客户*/
            int BUSIBESS_CUSTOMER = 7;
            /** 8-经纪人*/
            int BROKER = 8;
            /** 9-门店地推 */
            int STORES_TO_PUSH = 9;
        }
    }

    interface REPORT {
        /**
         * 报表类型：1-转账/营收报表
         */
        interface REPORT_TYPE {
            /** 1-转账/营收报表 */
            int TRANSFER = 1;
        }

        /**
         * 是否订正过：0-否，1-是
         */
        interface IS_CORRECTED {
            /** 1-是 */
            int YES = 1;
        }
    }
}
