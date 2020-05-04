package cooks;

import com.baidu.aip.http.AipRequest;
import com.baidu.aip.imageclassify.AipImageClassify;
import com.baidu.aip.util.Base64Util;

import org.json.JSONObject;

import java.util.HashMap;

public class AipImageClassifyBeta extends AipImageClassify {
    //食材识别接口
    static final String INGREDIENT_URL="https://aip.baidubce.com/rest/2.0/image-classify/v1/classify/ingredient";

    public AipImageClassifyBeta (String appId, String apiKey, String secretKey) {
        super(appId, apiKey, secretKey);
    }
    /**
     * 食材识别
     * @param image 图片本地路径
     * @param options 其他参数
     * @return JSONObject
     */
    public JSONObject ingredientDetect(byte[] data, HashMap options) {
        AipRequest request = new AipRequest();
        preOperation(request);
        //            byte[] data = Util.readFileByBytes(image);
        String base64Content = Base64Util.encode(data);
        request.addBody("image", base64Content);
        if (options != null) {
            request.addBody(options);
        }
        request.setUri(INGREDIENT_URL);
        postOperation(request);
        return requestServer(request);
    }

}
