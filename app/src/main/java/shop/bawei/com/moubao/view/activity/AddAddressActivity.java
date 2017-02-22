package shop.bawei.com.moubao.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import shop.bawei.com.moubao.R;
import shop.bawei.com.moubao.model.beans.AddressBean;
import shop.bawei.com.moubao.model.beans.DelAddressBean;
import shop.bawei.com.moubao.model.beans.ShopingAddressBean;
import shop.bawei.com.moubao.percent.AddAddressPercent;
import shop.bawei.com.moubao.system.Url;
import shop.bawei.com.moubao.utils.OkHttpUtils;
import shop.bawei.com.moubao.utils.SpUtils;
import shop.bawei.com.moubao.utils.ToastUtil;
import shop.bawei.com.moubao.view.interfaces.AddAddressView;

/**
 * Created by 刘伊帆 on 2017/2/10.
 */

public class AddAddressActivity extends BaseActivity implements AddAddressView,View.OnClickListener{
    //p层实例
    private AddAddressPercent addressPercent;
    private Spinner province;
    private Spinner city;
    private Spinner district;
    private EditText address;
    private EditText phone;
    private EditText name;
    private Button backBtn;
    private Button okBtn;
    private CheckBox checkBox;
    private String key;
    private String cityString;
    private String areaString;
    private String cityIdString;
    private String areaIdString;
    private String provinceString;
    private ArrayList<String> proviceList ;
    private ArrayList<String> cityList ;
    private ArrayList<String> districtList;
    private ArrayList<String> proviceIdList;
    private ArrayList<String> cityIdList;
    private ArrayList<String> districtIdList;
    private String address1;
    private ShopingAddressBean.DatasBean.AddressListBean addressListBean;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shipping_address_activity);
        initViews();
        initDatas();
    }

    @Override
    public void initViews() {
        province = (Spinner) findViewById(R.id.addaddress_provinceSpinner);
        city = (Spinner) findViewById(R.id.addaddress_citySpinner);
        district = (Spinner) findViewById(R.id.addaddress_areaSpinner);
        address = (EditText) findViewById(R.id.addressEditText);
        phone = (EditText) findViewById(R.id.mobilePhoneEditText);
        name = (EditText) findViewById(R.id.trueNameEditText);
        backBtn = (Button) findViewById(R.id.addaddress_btn_back);
        okBtn = (Button) findViewById(R.id.address_ok_btn);
        checkBox = (CheckBox) findViewById(R.id.defaultCheckBox);
        okBtn.setOnClickListener(this);
        backBtn.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    public void initDatas() {
        addressPercent = new AddAddressPercent();
        addressPercent.attachView(this);
        key = (String) SpUtils.getParam(this, Url.SOAL_TOKEN,"");
        addressPercent.getpDataFromNet(Url.LINK_MOBILE_AREA,new OkHttpUtils.Param("key",key));
        Intent intent = getIntent();
        address1 = intent.getStringExtra("from");
        if("AddAddressActivity".equals(address1)){
            addressListBean = (ShopingAddressBean.DatasBean.AddressListBean) intent.getSerializableExtra("address");
            address.setText(addressListBean.getAddress());
            phone.setText(addressListBean.getMob_phone());
            name.setText(addressListBean.getTrue_name());
            if("1".equals(addressListBean.getIs_default())){
                checkBox.setChecked(true);
            }else{
                checkBox.setChecked(false);
            }
        }
    }

    @Override
    public void addAddressSuccess(AddressBean addressBean) {
        ToastUtil.show(this,"添加成功");
        finish();
    }

    @Override
    public void getProvince(AddressBean addressBean) {
        proviceList = new ArrayList<>();
        proviceIdList = new ArrayList<>();
        for (AddressBean.DatasBean.AreaListBean ab:addressBean.getDatas().getArea_list()){
            proviceList.add(ab.getArea_name());
            proviceIdList.add(ab.getArea_id());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, proviceList);
        province.setAdapter(adapter);
        province.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                TextView textView = (TextView) view;
                textView.setGravity(Gravity.CENTER);
                textView.setTextSize(14.0f);
                addressPercent.getcityFromNet(Url.LINK_MOBILE_AREA,new OkHttpUtils.Param("key",key),new OkHttpUtils.Param("area_id",proviceIdList.get(i)));
                provinceString = proviceList.get(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    @Override
    public void getCity(AddressBean addressBean) {
        cityList = new ArrayList<>();
        cityIdList = new ArrayList<>();
        for (AddressBean.DatasBean.AreaListBean ab:addressBean.getDatas().getArea_list()){
            cityList.add(ab.getArea_name());
            cityIdList.add(ab.getArea_id());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, cityList);
        city.setAdapter(adapter);
        city.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                TextView textView = (TextView) view;
                textView.setGravity(Gravity.CENTER);
                textView.setTextSize(14.0f);
                addressPercent.getDistrictFromNet(Url.LINK_MOBILE_AREA,new OkHttpUtils.Param("key",key),new OkHttpUtils.Param("area_id",cityIdList.get(i)));
                cityIdString = cityIdList.get(i);
                cityString = cityList.get(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    @Override
    public void getDistrict(AddressBean addressBean) {
        districtList = new ArrayList<>();
        districtIdList = new ArrayList<>();
        for (AddressBean.DatasBean.AreaListBean ab:addressBean.getDatas().getArea_list()){
            districtList.add(ab.getArea_name());
            districtIdList.add(ab.getArea_id());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, districtList);
        district.setAdapter(adapter);
        district.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                TextView textView = (TextView) view;
                textView.setGravity(Gravity.CENTER);
                textView.setTextSize(14.0f);
                areaIdString = districtIdList.get(i);
                areaString = districtList.get(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    @Override
    public void upData(DelAddressBean addressBean) {
        ToastUtil.show(this,"修改成功");
        finish();
    }

    /**
     * AjaxParams ajaxParams = new AjaxParams();
     ajaxParams.put("key", Constant.userKeyString);
     ajaxParams.put("true_name", trueNameEditText.getText().toString());
     ajaxParams.put("mob_phone", mobilePhoneEditText.getText().toString());
     ajaxParams.put("city_id", cityIdString);
     ajaxParams.put("area_id", areaIdString);
     ajaxParams.put("address", addressEditText.getText().toString());
     ajaxParams.put("area_info", provinceString + " " + cityString + " " + areaString);
     if (defaultCheckBox.isChecked()) {
     ajaxParams.put("is_default", "1");
     } else {
     ajaxParams.put("is_default", "0");
     }
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.address_ok_btn:
                if (address.getText().toString().isEmpty()) {
                    ToastUtil.show(this, "请输入详细地址");
                    return;
                }
                if (phone.getText().toString().isEmpty()) {
                    ToastUtil.show(this, "请输入手机号码");
                    return;
                }
                if (name.getText().toString().isEmpty()) {
                    ToastUtil.show(this, "请输入真实姓名");
                    return;
                }
                if("AddAddressActivity".equals(address1)){
                    addressPercent.upDataFromNet(Url.LINK_MOBILE_ADDRESS_EDIT,new OkHttpUtils.Param("key",key),
                            new OkHttpUtils.Param("address_id",addressListBean.getAddress_id()),
                            new OkHttpUtils.Param("true_name",name.getText().toString().trim()),
                            new OkHttpUtils.Param("mob_phone",phone.getText().toString().trim()),
                            new OkHttpUtils.Param("city_id",cityIdString),
                            new OkHttpUtils.Param("area_id",areaIdString),
                            new OkHttpUtils.Param("address",address.getText().toString().trim()),
                            new OkHttpUtils.Param("area_info",provinceString + " " + cityString + " " + areaString),
                            new OkHttpUtils.Param("is_default",checkBox.isChecked()?"1":"0")
                    );
                }else {
                    addressPercent.loadDataFromNet(Url.LINK_MOBILE_ADDRESS_ADD,
                            new OkHttpUtils.Param("key",key),
                            new OkHttpUtils.Param("true_name",name.getText().toString().trim()),
                            new OkHttpUtils.Param("mob_phone",phone.getText().toString().trim()),
                            new OkHttpUtils.Param("city_id",cityIdString),
                            new OkHttpUtils.Param("area_id",areaIdString),
                            new OkHttpUtils.Param("address",address.getText().toString().trim()),
                            new OkHttpUtils.Param("area_info",provinceString + " " + cityString + " " + areaString),
                            new OkHttpUtils.Param("is_default",checkBox.isChecked()?"1":"0")
                    );
                }

                break;
            case R.id.addaddress_btn_back:
                finish();
                break;
        }
    }
}
