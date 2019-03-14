package com.yuyenews.remote.config;

import com.yuyenews.core.annotation.Controller;
import com.yuyenews.core.annotation.EasyLog;
import com.yuyenews.core.annotation.EasyMapping;
import com.yuyenews.core.annotation.enums.RequestMetohd;
import com.yuyenews.core.remote.config.RemoteConfigService;
import com.yuyenews.easy.server.request.HttpRequest;
import com.yuyenews.easy.server.request.HttpResponse;

import java.util.HashMap;
import java.util.Map;

/**
 * 修改远程配置后 接受配置中心的通知
 */
@Controller
public class RemoteConfigController {

    /**
     * 重新加载配置
     * @param request
     * @param response
     * @return 结果
     */
    @EasyMapping(value = "reloadConfig",method = RequestMetohd.POST)
    @EasyLog
    public Map<String,Object> reloadConfig(HttpRequest request, HttpResponse response) {
        Object config = request.getParemeter("config");
        String result = RemoteConfigService.reloadConfig(config);

        Map<String,Object> returns = new HashMap<>();
        if(result.equals("ok")){
            returns.put("msg","通知成功");
            returns.put("success","ok");
        } else {
            returns.put("msg","通知失败");
            returns.put("success","no");
        }
        return returns;
    }
}
