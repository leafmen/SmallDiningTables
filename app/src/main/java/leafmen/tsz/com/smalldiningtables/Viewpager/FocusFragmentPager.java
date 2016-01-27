package leafmen.tsz.com.smalldiningtables.Viewpager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import leafmen.tsz.com.smalldiningtables.R;
import leafmen.tsz.com.smalldiningtables.Utils.LogUtils;

/**
 * Created by LiQiang on 2016/1/13.
 */

public class FocusFragmentPager extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private WebView webView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_focus_webview, null, false);

        Bundle bundle = getArguments();
        LogUtils.e("bundle", bundle + "");
        if (bundle != null) {
            String gourl = getUrl(bundle.getString("gourl"));
            webView = (WebView) view.findViewById(R.id.webView);
            if (gourl.length() > 0) {
                webView.loadUrl(gourl);
            }
        }

        return view;
    }

    private String url;

    private String getUrl(String rburl) {
        switch (rburl) {
            case "foucs_rb1":
                url = "http://www.qq.com";
                break;
            case "foucs_rb2":
                url = "http://www.jd.com";
                break;
            case "foucs_rb3":
                url = "http://www.taobao.com";
                break;
            case "foucs_rb4":
                url = "http://www.sina.com";
                break;
            case "foucs_rb5":
                url = "http://www.yun-zhang.com";
                break;
            case "foucs_rb6":
                url = "http://www.sohu.com";
                break;
            case "foucs_rb7":
                url = "http://www.sohu.com";
                break;
            default:
                url = "http://www.z.cn";
                break;

        }
        return url;
    }
}
