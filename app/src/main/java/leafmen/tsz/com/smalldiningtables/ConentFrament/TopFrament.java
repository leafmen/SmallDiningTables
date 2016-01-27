package leafmen.tsz.com.smalldiningtables.ConentFrament;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import leafmen.tsz.com.smalldiningtables.Activitys.BannerView;
import leafmen.tsz.com.smalldiningtables.R;

/**
 * Created by LiQiang on 2016/1/27.
 */
public class TopFrament extends Fragment implements View.OnClickListener {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_top_main, null, false);
        initBannerView(view);
        return view;
    }

    @Override
    public void onClick(View v) {

    }

    private void initBannerView(View view) {
        BannerView bannerview = (BannerView) view.findViewById(R.id.bannerview);
        int[] imageIds = new int[]{R.drawable.im1, R.drawable.im2, R.drawable.im3, R.drawable.im4};
        String[] titles = new String[]{"那瞬间的美", "清冷的夏日", "炽热的心", "朦胧的眼神"};
        int count = imageIds.length;
        bannerview.setView(imageIds, titles, count);
        bannerview.startPlay();
    }
}
