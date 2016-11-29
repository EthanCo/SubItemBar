# SubTitleBar #
二级标题，效果如图所示  

![](/SubItemBar.png)  

支持文字左侧和右侧设置图标。  

## 添加依赖 ##
###Step 1. Add the JitPack repository to your build file
Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}

###Step 2. Add the dependency

	dependencies {
	    compile 'com.github.EthanCo:SubItemBar:-SNAPSHOT'
	}

### 使用 ###

	<com.ethanco.subitembar.SubTitleBar
        android:id="@+id/sub_title_bar"
        android:layout_width="match_parent"
        android:layout_height="36dp"
        android:layout_marginLeft="10dp"
        android:layout_marginRight="10dp"
        app:left_text="标题"
        app:left_text_color="@android:color/holo_red_light"
        app:left_text_drawableLeft="@mipmap/ic_launcher"
        app:left_text_drawableRight="@mipmap/ic_launcher"
        app:left_text_drawableLeftSize="25dp"
        app:left_text_drawablePadding="5dp"
        app:left_text_size="18sp"
        app:right_text="更多"
        app:right_text_color="@android:color/holo_red_light"
        app:right_text_drawableRight="@mipmap/ic_launcher"
        app:right_text_drawableLeft="@mipmap/ic_launcher"
        app:right_text_drawableLeftSize="20dp"
        app:right_text_drawablePadding="5dp"
        app:right_text_size="14sp">  

### 可使用的属性 ###

	 <declare-styleable name="SubTitleBar">
        <!--右侧文字-->
        <attr name="right_text" format="string" />
        <!--右侧文字大小-->
        <attr name="right_text_size" format="dimension" />
        <!--右侧文字颜色-->
        <attr name="right_text_color" format="color" />
        <!--右侧文字 drawableLeft 图片-->
        <attr name="right_text_drawableLeft" format="reference" />
        <!--右侧文字 drawableRight 图片-->
        <attr name="right_text_drawableRight" format="reference" />
        <!--右侧文字 drawableLeft 长宽-->
        <attr name="right_text_drawableLeftSize" format="dimension" />
        <!--右侧文字 drawableRight 长宽-->
        <attr name="right_text_drawableRightSize" format="dimension" />
        <!--右侧文字 drawablePadding-->
        <attr name="right_text_drawablePadding" format="dimension" />

        <!--左侧文字-->
        <attr name="left_text" format="string" />
        <!--左侧文字大小-->
        <attr name="left_text_size" format="dimension" />
        <!--左侧文字颜色-->
        <attr name="left_text_color" format="color" />
        <!--左侧文字 drawableLeft 图片-->
        <attr name="left_text_drawableLeft" format="reference" />
        <!--左侧文字 drawableRight 图片-->
        <attr name="left_text_drawableRight" format="reference" />
        <!--左侧文字 drawableLeft 长宽-->
        <attr name="left_text_drawableLeftSize" format="dimension" />
        <!--左侧文字 drawableRight 长宽-->
        <attr name="left_text_drawableRightSize" format="dimension" />
        <!--左侧文字 drawablePadding-->
        <attr name="left_text_drawablePadding" format="dimension" />
    </declare-styleable>  

### 设置点击事件 ###

	subTitleBar.addOnLeftTextClickListener(new OnLeftTextClickListener() {
        @Override
        public void onClick(SubTitleBar bar) {
            Toast.makeText(MainActivity.this, "左侧被点击:"+bar.getLeftText(), Toast.LENGTH_SHORT).show();
        }
    });

    subTitleBar.addOnRightTextClickListener(new OnRightTextClickListener() {
        @Override
        public void onClick(SubTitleBar bar) {
            Toast.makeText(MainActivity.this, "右侧被点击"+bar.getRightText(), Toast.LENGTH_SHORT).show();
        }
    });  

### 也可使用Style进行全局设置 ###

#### styles.xml ####
	 <style name="MySubItemBarStyle">
        <!--右侧文字-->
        <item name="right_text">更多</item>
        <!--右侧文字大小-->
        <item name="right_text_size">14sp</item>
        <!--右侧文字颜色-->
        <item name="right_text_color">@android:color/holo_blue_dark</item>
        <!--右侧文字 drawableLeft 图片-->
        <!--<item name="right_text_drawableLeft"></item>-->
        <!--右侧文字 drawableRight 图片-->
        <!--<item name="right_text_drawableRight"></item>-->
        <!--右侧文字 drawableLeft 长宽-->
        <item name="right_text_drawableLeftSize">20dp</item>
        <!--右侧文字 drawableRight 长宽-->
        <item name="right_text_drawableRightSize">20dp</item>
        <!--右侧文字 drawablePadding-->
        <item name="right_text_drawablePadding">5dp</item>

        <!--左侧文字-->
        <item name="left_text">标题</item>
        <!--左侧文字大小-->
        <item name="left_text_size">18sp</item>
        <!--左侧文字颜色-->
        <item name="left_text_color">@android:color/holo_blue_dark</item>
        <!--左侧文字 drawableLeft 图片-->
        <!--<item name="left_text_drawableLeft"></item>-->
        <!--左侧文字 drawableRight 图片-->
        <!--<item name="left_text_drawableRight"></item>-->
        <!--左侧文字 drawableLeft 长宽-->
        <item name="left_text_drawableLeftSize">25dp</item>
        <!--左侧文字 drawableRight 长宽-->
        <item name="left_text_drawableRightSize">25dp</item>
        <!--左侧文字 drawablePadding-->
        <item name="left_text_drawablePadding">5dp</item>

        <!--android 属性-->
        <item name="android:layout_marginLeft">10dp</item>
        <item name="android:layout_marginRight">10dp</item>
        <item name="android:layout_height">36dp</item>
    </style>  

#### 在布局中 ####

	 <com.ethanco.subitembar.SubTitleBar
        android:id="@+id/sub_title_bar_custom_style"
        style="@style/MySubItemBarStyle"
        android:layout_width="match_parent"
        app:left_text_drawableLeft="@mipmap/ic_launcher"
        app:right_text_drawableRight="@mipmap/ic_launcher">  