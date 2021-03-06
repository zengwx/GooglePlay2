package com.example.googleplay.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.googleplay.R;
import com.example.googleplay.base.BaseHolder;
import com.example.googleplay.bean.AppInfoBean;
import com.example.googleplay.conf.Constants.URLS;
import com.example.googleplay.utils.BitmapHelper;
import com.example.googleplay.utils.StringUtils;
import com.example.googleplay.utils.UIUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AppDetailInfoHolder extends BaseHolder<AppInfoBean> {

    @BindView(R.id.app_detail_info_iv_icon) ImageView InfoIvIcon;
    @BindView(R.id.app_detail_info_rb_star) RatingBar infoRbStar;
    @BindView(R.id.app_detail_info_tv_name) TextView InfoTvName;
    @BindView(R.id.app_detail_info_tv_downloadnum) TextView InfoTvDownloadNum;
    @BindView(R.id.app_detail_info_tv_version) TextView InfoTvVersion;
    @BindView(R.id.app_detail_info_tv_time) TextView InfoTvTime;
    @BindView(R.id.app_detail_info_tv_size) TextView InfoTvSize;

    @Override
    public View initHolderView() {
        View view = View.inflate(UIUtils.getContext(), R.layout.app_detail_info, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void refreshHolderView(AppInfoBean data) {

        infoRbStar.setRating(data.stars);
        InfoTvName.setText(data.name);

        String downloadNum = UIUtils.getString(R.string.detail_downloadnum, data.downloadNum);
        String version = UIUtils.getString(R.string.detail_version, data.version);
        String date = UIUtils.getString(R.string.detail_date, data.date);
        String size = UIUtils.getString(R.string.detail_size, StringUtils.formatFileSize(data.size));

        InfoTvDownloadNum.setText(downloadNum);
        InfoTvVersion.setText(version);
        InfoTvTime.setText(date);
        InfoTvSize.setText(size);

        InfoIvIcon.setImageResource(R.drawable.ic_default);

        String ivIconUrl = URLS.IMAGE_BASE_URL + data.iconUrl;
        BitmapHelper.display(InfoIvIcon, ivIconUrl);
    }

}
