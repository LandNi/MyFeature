package com.land.myfeature;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.ashokvarma.bottomnavigation.ShapeBadgeItem;
import com.ashokvarma.bottomnavigation.TextBadgeItem;

public class BottomNaviBarActivity extends AppCompatActivity {
    private static final String TAG = "BottomNaviBarActivity";

    private BottomNavigationBar mBottomNavigationBar;
    private BottomNavigationItem saleBottomNavigationItem;
    private BottomNavigationItem transBottomNavigationItem;
    private BottomNavigationItem manageBottomNavigationItem;
    private TextBadgeItem mTextBadgeItem;
    private ShapeBadgeItem mShapeBadgeItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navi_bar);
        initBadge();
        InitNavigationBar();

        new Thread() {
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                BottomNaviBarActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Log.d(TAG, "run: setBadgeItem");
                        mTextBadgeItem.show();
                        mShapeBadgeItem.show();
                    }
                });


            }
        }.start();

    }


    private void InitNavigationBar() {


        saleBottomNavigationItem = new BottomNavigationItem(R.mipmap.sale_normal, "收款")
                .setActiveColorResource(R.color.blue_text);
        transBottomNavigationItem = new BottomNavigationItem(R.mipmap.trans_normal, "流水")
                .setActiveColorResource(R.color.blue_text).setBadgeItem(mTextBadgeItem);
        manageBottomNavigationItem = new BottomNavigationItem(R.mipmap.manage_normal, "管理")
                .setActiveColorResource(R.color.blue_text)
                .setBadgeItem(mShapeBadgeItem);

        mBottomNavigationBar = findViewById(R.id.bottom_navigation_bar);
        mBottomNavigationBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position) {
                switch (position) {
                    case 0:
                        break;
                    case 1:
                        mTextBadgeItem.hide();
                        break;
                    case 2:
                        mShapeBadgeItem.hide();
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onTabUnselected(int position) {

            }

            @Override
            public void onTabReselected(int position) {

            }
        });

        /**
         * 1.Mode
         * 在xml代码使用android:bnbMode属性
         * 在Java代码中使用setMode方法
         * MODE_DEFAULT：如果Item的个数<=3就会使用MODE_FIXED模式，否则使用MODE_SHIFTING模式。
         * MODE_FIXED：填充模式，未选中的Item会显示文字，没有换挡动画。
         * MODE_SHIFTING：换挡模式，未选中的Item不会显示文字，选中的会显示文字。在切换的时候会有一个像换挡的动画。
         * =========================================================================================
         * 2.BackgroundStyle
         * 在xml代码使用android:bnbBackgroundStyle属性
         * 在Java代码中使用setBackgroundStyle方法
         * BACKGROUND_STYLE_DEFAULT : 如果设置的Mode为MODE_FIXED，将使用BACKGROUND_STYLE_STATIC 。
         *                            如果Mode为MODE_SHIFTING将使用BACKGROUND_STYLE_RIPPLE。
         * BACKGROUND_STYLE_STATIC  : 点击的时候没有水波纹效果
         * BACKGROUND_STYLE_RIPPLE  : 点击的时候有水波纹效果
         *
         * =========================================================================================
         * 3.设置默认颜色
         * xml：bnbActiveColor, bnbInactiveColor, bnbBackgroundColor
         * 方法：setActiveColor, setInActiveColor, setBarBackgroundColor
         *
         * 例如：bottomNavigationBar.setActiveColor(R.color.primary)
         *                         .setInActiveColor("#FFFFFF")
         *                         .setBarBackgroundColor("#ECECEC")
         *
         * in-active color：表示未选中Item中的图标和文本颜色。默认为 Color.LTGRAY
         * active color : 在BACKGROUND_STYLE_STATIC下，表示选中Item的图标和文本颜色。
         *                而在BACKGROUND_STYLE_RIPPLE下，表示整个容器的背景色。默认Theme's Primary Color
         *
         * background color :在BACKGROUND_STYLE_STATIC下，表示整个容器的背景色。
         *                   而在BACKGROUND_STYLE_RIPPLE下，表示选中Item的图标和文本颜色。
         *                   默认 Color.WHITE
         * =========================================================================================
         * 4.定制Item的选中未选中颜色
         * 我们可以为每个Item设置选中未选中的颜色，如果没有设置，将继承BottomNavigationBar设置的选中未选中颜色。
         * 方法：
         * BottomNavigationItem.setInActiveColor() 设置Item未选中颜色方法
         * BottomNavigationItem.setActiveColor() 设置Item选中颜色方法
         * ==========================================================================================
         * 5.Icon的定制
         * 如果使用颜色的变化不足以展示一个选项Item的选中与非选中状态，可以使用BottomNavigationItem.setInActiveIcon()方法来设置。
         * 例如：
         *  new BottomNavigationItem(R.mipmap.ic_directions_bus_white_24dp, "公交")//这里表示选中的图片
         *        .setInactiveIcon(ContextCompat.getDrawable(this,R.mipmap.ic_launcher)))//非选中的图片
         *
         * =========================================================================================
         * 6.设置自动隐藏与显示
         * 如果BottomNavigationBar是在CoordinatorLayout布局里，默认设置当向下滑动时会自动隐藏它，当向上滑动时
         * 会自动显示它。我们可以通过setAutoHideEnabled(boolean)设置是否允许这种行为,好像这个方法木有啦。
         * =========================================================================================
         * 7.手动隐藏与显示
         * bottomNavigationBar.hide();//隐藏
         * bottomNavigationBar.hide(true);//隐藏是否启动动画，这里并不能自定义动画
         * bottomNavigationBar.unHide();//显示
         * bottomNavigationBar.hide(true);//隐藏是否启动动画，这里并不能自定义动画
         * 实际上这里都是通过属性动画ViewPropertyAnimatorCompat来完成的，所以如果我们要自定义它的隐藏和显示的话，
         * 通过属性动画即可实现。
         *
         * */
        mBottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
        mBottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
        mBottomNavigationBar.addItem(saleBottomNavigationItem)
                .addItem(transBottomNavigationItem)
                .addItem(manageBottomNavigationItem)
                .setFirstSelectedPosition(0)
                .initialise();
    }

    /**
     * 导航图标右上角小提示
     */
    public void initBadge() {
        mTextBadgeItem = new TextBadgeItem()
                .setBorderWidth(2)//边框宽度
                .setBorderColor("#ff0000")//边框颜色
                .setBackgroundColor("#ff0000")//背景颜色
                .setGravity(Gravity.RIGHT | Gravity.TOP)//位置
                .setText("1")//显示文字
                .setTextColor("#ffffff")//文字颜色
                .setAnimationDuration(200)//渐退、渐出的时间
                .setHideOnSelect(false)//选中时是否消失
                .hide();

        mShapeBadgeItem = new ShapeBadgeItem()
                .setShape(ShapeBadgeItem.SHAPE_OVAL)
                .setShapeColor("#ff0000")
                .setSizeInDp(this, 10, 10)
                .setGravity(Gravity.TOP | Gravity.END)
                .setEdgeMarginInDp(this, 2)
                .setHideOnSelect(false)
                .hide();
    }
}
