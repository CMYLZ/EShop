package cniao5.com.cniao5shop.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.widget.Button;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import cniao5.com.cniao5shop.R;
import cniao5.com.cniao5shop.bean.Wares;
import cniao5.com.cniao5shop.utils.CartProvider;
import cniao5.com.cniao5shop.utils.ToastUtils;

/**
 * Created by <a href="http://www.cniao5.com">菜鸟窝</a>
 * 一个专业的Android开发在线教育平台
 */
public class HWAdatper extends SimpleAdapter<Wares> {

    CartProvider provider ;
    List<Wares> oldDatas;
    public HWAdatper(Context context, List<Wares> datas) {
        super(context, R.layout.template_hot_wares, datas);

        provider = new CartProvider(context);
    }
    public void search(String key){
        if(this.oldDatas==null) {
            this.oldDatas = new ArrayList<Wares>();
            for(int i=0;i<this.datas.size();i++){
                this.oldDatas.add(this.datas.get(i));
            }
        }
        //搜索
        if(key==null||key==""){
            this.datas=this.oldDatas;
        }else{
            this.datas.clear();
            for(int i=0;i<this.oldDatas.size();i++){
                if(this.oldDatas.get(i).getName().contains(key)){
                    this.datas.add(this.oldDatas.get(i));
                }
        }
        }
        notifyDataSetChanged();
    }

    @Override
    protected void convert(BaseViewHolder viewHolder, final Wares wares) {

        SimpleDraweeView draweeView = (SimpleDraweeView) viewHolder.getView(R.id.drawee_view);
        draweeView.setImageURI(Uri.parse(wares.getImgUrl()));

        viewHolder.getTextView(R.id.text_title).setText(wares.getName());
        viewHolder.getTextView(R.id.text_price).setText("￥ "+wares.getPrice());

        Button button =viewHolder.getButton(R.id.btn_add);
        if(button !=null) {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    provider.put(wares);

                    ToastUtils.show(context, "已添加到购物车");
                }
            });
        }

    }




    public void  resetLayout(int layoutId){


        this.layoutResId  = layoutId;

        notifyItemRangeChanged(0,getDatas().size());


    }



}
