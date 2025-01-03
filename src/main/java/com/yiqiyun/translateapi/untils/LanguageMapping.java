package com.yiqiyun.translateapi.untils;

import java.util.HashMap;
import java.util.Map;


/**
 * 语言映射工具类
 * 用于将输入的目标语言映射到 Google 和 Bing 翻译 API 使用的语言代码
 *
 * @author 17Yuns
 */

public class LanguageMapping {

    // Google 和 Bing 的语言映射
    private static final Map<String, String> GOOGLE_LANG_MAP = new HashMap<>();
    private static final Map<String, String> BING_LANG_MAP = new HashMap<>();

    static {
        // Google 翻译支持的语言映射
        GOOGLE_LANG_MAP.put("sq", "sq"); // 阿尔巴尼亚语
        GOOGLE_LANG_MAP.put("ar", "ar"); // 阿拉伯语
        GOOGLE_LANG_MAP.put("am", "am"); // 阿姆哈拉语
        GOOGLE_LANG_MAP.put("az", "az"); // 阿塞拜疆语
        GOOGLE_LANG_MAP.put("ga", "ga"); // 爱尔兰语
        GOOGLE_LANG_MAP.put("et", "et"); // 爱沙尼亚语
        GOOGLE_LANG_MAP.put("eu", "eu"); // 巴斯克语
        GOOGLE_LANG_MAP.put("be", "be"); // 白俄罗斯语
        GOOGLE_LANG_MAP.put("bg", "bg"); // 保加利亚语
        GOOGLE_LANG_MAP.put("is", "is"); // 冰岛语
        GOOGLE_LANG_MAP.put("pl", "pl"); // 波兰语
        GOOGLE_LANG_MAP.put("bs", "bs"); // 波斯尼亚语
        GOOGLE_LANG_MAP.put("fa", "fa"); // 波斯语
        GOOGLE_LANG_MAP.put("af", "af"); // 布尔语(南非荷兰语)
        GOOGLE_LANG_MAP.put("da", "da"); // 丹麦语
        GOOGLE_LANG_MAP.put("de", "de"); // 德语
        GOOGLE_LANG_MAP.put("ru", "ru"); // 俄语
        GOOGLE_LANG_MAP.put("fr", "fr"); // 法语
        GOOGLE_LANG_MAP.put("tl", "tl"); // 菲律宾语
        GOOGLE_LANG_MAP.put("fi", "fi"); // 芬兰语
        GOOGLE_LANG_MAP.put("fy", "fy"); // 弗里西语
        GOOGLE_LANG_MAP.put("km", "km"); // 高棉语
        GOOGLE_LANG_MAP.put("ka", "ka"); // 格鲁吉亚语
        GOOGLE_LANG_MAP.put("gu", "gu"); // 古吉拉特语
        GOOGLE_LANG_MAP.put("kk", "kk"); // 哈萨克语
        GOOGLE_LANG_MAP.put("ht", "ht"); // 海地克里奥尔语
        GOOGLE_LANG_MAP.put("ko", "ko"); // 韩语
        GOOGLE_LANG_MAP.put("ha", "ha"); // 豪萨语
        GOOGLE_LANG_MAP.put("nl", "nl"); // 荷兰语
        GOOGLE_LANG_MAP.put("ky", "ky"); // 吉尔吉斯语
        GOOGLE_LANG_MAP.put("gl", "gl"); // 加利西亚语
        GOOGLE_LANG_MAP.put("ca", "ca"); // 加泰罗尼亚语
        GOOGLE_LANG_MAP.put("cs", "cs"); // 捷克语
        GOOGLE_LANG_MAP.put("kn", "kn"); // 卡纳达语
        GOOGLE_LANG_MAP.put("co", "co"); // 科西嘉语
        GOOGLE_LANG_MAP.put("hr", "hr"); // 克罗地亚语
        GOOGLE_LANG_MAP.put("ku", "ku"); // 库尔德语
        GOOGLE_LANG_MAP.put("la", "la"); // 拉丁语
        GOOGLE_LANG_MAP.put("lv", "lv"); // 拉脱维亚语
        GOOGLE_LANG_MAP.put("lo", "lo"); // 老挝语
        GOOGLE_LANG_MAP.put("lt", "lt"); // 立陶宛语
        GOOGLE_LANG_MAP.put("lb", "lb"); // 卢森堡语
        GOOGLE_LANG_MAP.put("ro", "ro"); // 罗马尼亚语
        GOOGLE_LANG_MAP.put("mg", "mg"); // 马尔加什语
        GOOGLE_LANG_MAP.put("mt", "mt"); // 马耳他语
        GOOGLE_LANG_MAP.put("mr", "mr"); // 马拉地语
        GOOGLE_LANG_MAP.put("ml", "ml"); // 马拉雅拉姆语
        GOOGLE_LANG_MAP.put("ms", "ms"); // 马来语
        GOOGLE_LANG_MAP.put("mk", "mk"); // 马其顿语
        GOOGLE_LANG_MAP.put("mi", "mi"); // 毛利语
        GOOGLE_LANG_MAP.put("mn", "mn"); // 蒙古语
        GOOGLE_LANG_MAP.put("bn", "bn"); // 孟加拉语
        GOOGLE_LANG_MAP.put("my", "my"); // 缅甸语
        GOOGLE_LANG_MAP.put("hmn", "hmn"); // 苗语
        GOOGLE_LANG_MAP.put("xh", "xh"); // 南非科萨语
        GOOGLE_LANG_MAP.put("zu", "zu"); // 南非祖鲁语
        GOOGLE_LANG_MAP.put("ne", "ne"); // 尼泊尔语
        GOOGLE_LANG_MAP.put("no", "no"); // 挪威语
        GOOGLE_LANG_MAP.put("pa", "pa"); // 旁遮普语
        GOOGLE_LANG_MAP.put("pt", "pt"); // 葡萄牙语
        GOOGLE_LANG_MAP.put("ps", "ps"); // 普什图语
        GOOGLE_LANG_MAP.put("ny", "ny"); // 齐切瓦语
        GOOGLE_LANG_MAP.put("ja", "ja"); // 日语
        GOOGLE_LANG_MAP.put("sv", "sv"); // 瑞典语
        GOOGLE_LANG_MAP.put("sm", "sm"); // 萨摩亚语
        GOOGLE_LANG_MAP.put("sr", "sr"); // 塞尔维亚语
        GOOGLE_LANG_MAP.put("st", "st"); // 塞索托语
        GOOGLE_LANG_MAP.put("sib", "sib"); // 僧伽罗语
        GOOGLE_LANG_MAP.put("eob", "eob"); // 世界语
        GOOGLE_LANG_MAP.put("skb", "skb"); // 斯洛伐克语
        GOOGLE_LANG_MAP.put("slb", "slb"); // 斯洛文尼亚语
        GOOGLE_LANG_MAP.put("swb", "swb"); // 斯瓦希里语
        GOOGLE_LANG_MAP.put("gdb", "gdb"); // 苏格兰盖尔语
        GOOGLE_LANG_MAP.put("ceb", "ceb"); // 宿务语
        GOOGLE_LANG_MAP.put("sob", "sob"); // 索马里语
        GOOGLE_LANG_MAP.put("tgb", "tgb"); // 塔吉克语
        GOOGLE_LANG_MAP.put("teb", "teb"); // 泰卢固语
        GOOGLE_LANG_MAP.put("tab", "tab"); // 泰米尔语
        GOOGLE_LANG_MAP.put("thb", "thb"); // 泰语
        GOOGLE_LANG_MAP.put("trb", "trb"); // 土耳其语
        GOOGLE_LANG_MAP.put("cyb", "cyb"); // 威尔士语
        GOOGLE_LANG_MAP.put("urb", "urb"); // 乌尔都语
        GOOGLE_LANG_MAP.put("ukb", "ukb"); // 乌克兰语
        GOOGLE_LANG_MAP.put("uzb", "uzb"); // 乌兹别克语
        GOOGLE_LANG_MAP.put("esb", "esb"); // 西班牙语
        GOOGLE_LANG_MAP.put("iwb", "iwb"); // 希伯来语
        GOOGLE_LANG_MAP.put("elb", "elb"); // 希腊语
        GOOGLE_LANG_MAP.put("habw", "habw"); // 夏威夷语
        GOOGLE_LANG_MAP.put("sdb", "sdb"); // 信德语
        GOOGLE_LANG_MAP.put("hub", "hub"); // 匈牙利语
        GOOGLE_LANG_MAP.put("snb", "snb"); // 修纳语
        GOOGLE_LANG_MAP.put("hyb", "hyb"); // 亚美尼亚语
        GOOGLE_LANG_MAP.put("igb", "igb"); // 伊博语
        GOOGLE_LANG_MAP.put("itb", "itb"); // 意大利语
        GOOGLE_LANG_MAP.put("yib", "yib"); // 意第绪语
        GOOGLE_LANG_MAP.put("hib", "hib"); // 印地语
        GOOGLE_LANG_MAP.put("sub", "sub"); // 印尼巽他语
        GOOGLE_LANG_MAP.put("idb", "idb"); // 印尼语
        GOOGLE_LANG_MAP.put("jwb", "jwb"); // 印尼爪哇语
        GOOGLE_LANG_MAP.put("en", "en"); // 英语
        GOOGLE_LANG_MAP.put("yob", "yob"); // 约鲁巴语
        GOOGLE_LANG_MAP.put("vib", "vib"); // 越南语
        GOOGLE_LANG_MAP.put("zh", "zh-CN"); //简体中文

        // Bing 翻译语言映射
       BING_LANG_MAP.put("ar", "ar"); // 阿拉伯语
       BING_LANG_MAP.put("et", "et"); // 爱沙尼亚语
       BING_LANG_MAP.put("bg", "bg"); // 保加利亚语
       BING_LANG_MAP.put("is", "is"); // 冰岛语
       BING_LANG_MAP.put("pl", "pl"); // 波兰语
       BING_LANG_MAP.put("bs-Latn", "bs-Latn"); // 波斯尼亚语
       BING_LANG_MAP.put("fa", "fa"); // 波斯语
       BING_LANG_MAP.put("da", "da"); // 丹麦语
       BING_LANG_MAP.put("de", "de"); // 德语
       BING_LANG_MAP.put("ru", "ru"); // 俄语
       BING_LANG_MAP.put("fr", "fr"); // 法语
       BING_LANG_MAP.put("zh-CHT", "zh-CHT"); // 繁体中文
       BING_LANG_MAP.put("fil", "fil"); // 菲律宾语
       BING_LANG_MAP.put("fj", "fj"); // 斐济语
       BING_LANG_MAP.put("fi", "fi"); // 芬兰语
       BING_LANG_MAP.put("ht", "ht"); // 海地克里奥尔语
       BING_LANG_MAP.put("ko", "ko"); // 韩语
       BING_LANG_MAP.put("nl", "nl"); // 荷兰语
       BING_LANG_MAP.put("ca", "ca"); // 加泰罗尼亚语
       BING_LANG_MAP.put("zh", "zh-Hans"); // 简体中文
       BING_LANG_MAP.put("cs", "cs"); // 捷克语
       BING_LANG_MAP.put("otq", "otq"); // 克雷塔罗奥托米语
       BING_LANG_MAP.put("tlh", "tlh"); // 克林贡语
       BING_LANG_MAP.put("tlh-Qaak", "tlh-Qaak"); // 克林贡语(plqaD)
       BING_LANG_MAP.put("hr", "hr"); // 克罗埃西亚语
       BING_LANG_MAP.put("lv", "lv"); // 拉脱维亚语
       BING_LANG_MAP.put("lt", "lt"); // 立陶宛语
       BING_LANG_MAP.put("ro", "ro"); // 罗马尼亚语
       BING_LANG_MAP.put("mg", "mg"); // 马达加斯加语
       BING_LANG_MAP.put("mt", "mt"); // 马耳他语
       BING_LANG_MAP.put("ms", "ms"); // 马来语
       BING_LANG_MAP.put("bn-BD", "bn-BD"); // 孟加拉语
       BING_LANG_MAP.put("mww", "mww"); // 苗语
       BING_LANG_MAP.put("af", "af"); // 南非荷兰语
       BING_LANG_MAP.put("no", "no"); // 挪威语
       BING_LANG_MAP.put("pt", "pt"); // 葡萄牙语
       BING_LANG_MAP.put("ja", "ja"); // 日语
       BING_LANG_MAP.put("sv", "sv"); // 瑞典语
       BING_LANG_MAP.put("sm", "sm"); // 萨摩亚语
       BING_LANG_MAP.put("sr-Latn", "sr-Latn"); // 塞尔维亚语(拉丁语)
       BING_LANG_MAP.put("sr-Cyrl", "sr-Cyrl"); // 塞尔维亚语(西里尔文)
       BING_LANG_MAP.put("sk", "sk"); // 斯洛伐克语
       BING_LANG_MAP.put("sl", "sl"); // 斯洛文尼亚语
       BING_LANG_MAP.put("sw", "sw"); // 斯瓦希里语
       BING_LANG_MAP.put("ty", "ty"); // 塔希提语
       BING_LANG_MAP.put("te", "te"); // 泰卢固语
       BING_LANG_MAP.put("ta", "ta"); // 泰米尔语
       BING_LANG_MAP.put("th", "th"); // 泰语
       BING_LANG_MAP.put("to", "to"); // 汤加语
       BING_LANG_MAP.put("tr", "tr"); // 土耳其语
       BING_LANG_MAP.put("cy", "cy"); // 威尔士语
       BING_LANG_MAP.put("ur", "ur"); // 乌尔都语
       BING_LANG_MAP.put("uk", "uk"); // 乌克兰语
       BING_LANG_MAP.put("es", "es"); // 西班牙语
       BING_LANG_MAP.put("he", "he"); // 希伯来语
       BING_LANG_MAP.put("el", "el"); // 希腊语
       BING_LANG_MAP.put("hu", "hu"); // 匈牙利语
       BING_LANG_MAP.put("it", "it"); // 意大利语
       BING_LANG_MAP.put("hi", "hi"); // 印地语
       BING_LANG_MAP.put("id", "id"); // 印度尼西亚语
       BING_LANG_MAP.put("en", "en"); // 英语
       BING_LANG_MAP.put("yua", "yua"); // 尤卡坦玛雅语
       BING_LANG_MAP.put("vi", "vi"); // 越南语
       BING_LANG_MAP.put("yue", "yue"); // 粤语(繁体)


    }

    /**
     * 根据传入的 targetLang 获取对应的 Google 语言代码
     *
     * @param targetLang 输入的目标语言
     * @return Google API 使用的语言代码
     */
    public static String getGoogleLang(String targetLang) {
        // 将 targetLang 转换为小写
        String langKey = targetLang.toLowerCase();
        return GOOGLE_LANG_MAP.getOrDefault(langKey, "en");
    }

    /**
     * 根据传入的 targetLang 获取对应的 Bing 语言代码
     *
     * @param targetLang 输入的目标语言
     * @return Bing API 使用的语言代码
     */
    public static String getBingLang(String targetLang) {
        // 将 targetLang 转换为小写
        String langKey = targetLang.toLowerCase();
        return BING_LANG_MAP.getOrDefault(langKey, "en");
    }
}

