package com.example.hmand22vlasov;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class Payment_Activity extends AppCompatActivity {
    private EditText mEditMoney;
    private EditText mEditInfo;
    private CheckBox mBankCard;
    private CheckBox mNumberPhone;
    private CheckBox mCashAddress;
    private Button mPaymentOk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_);
        initPayment();
    }
    private void initPayment () {
        mEditMoney = findViewById(R.id.editInputMoney);
        mEditInfo = findViewById(R.id.editInfoPayment);
        mBankCard = findViewById(R.id.checkBoxBankCard);
        mNumberPhone = findViewById(R.id.checkBoxNumberPhone);
        mCashAddress = findViewById(R.id.checkBoxCashAddress);
        mPaymentOk = findViewById(R.id.buttonOkPayment);
        //int money = Integer.parseInt(mEditMoney.getText().toString());
        //String info = mEditInfo.getText().toString();
        CompoundButton.OnCheckedChangeListener checkedChangeListener = new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    switch (compoundButton.getId()) {
                        case R.id.checkBoxBankCard:
                            mCashAddress.setChecked(false);
                            mNumberPhone.setChecked(false);
                            mBankCard.setChecked(true);
                            mEditInfo.setInputType(InputType.TYPE_CLASS_TEXT);
                            break;
                        case R.id.checkBoxNumberPhone:
                            mCashAddress.setChecked(false);
                            mBankCard.setChecked(false);
                            mNumberPhone.setChecked(true);
                            mEditInfo.setInputType(InputType.TYPE_CLASS_PHONE);
                            break;
                        case R.id.checkBoxCashAddress:
                            mBankCard.setChecked(false);
                            mNumberPhone.setChecked(false);
                            mCashAddress.setChecked(true);
                            mEditInfo.setInputType(InputType.TYPE_CLASS_NUMBER);
                            break;
                        default:
                    }
                }
            }
        };
        mBankCard.setOnCheckedChangeListener(checkedChangeListener);
        mNumberPhone.setOnCheckedChangeListener(checkedChangeListener);
        mCashAddress.setOnCheckedChangeListener(checkedChangeListener);

        mPaymentOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mEditMoney.getText().toString().isEmpty()) {
                    Toast.makeText(Payment_Activity.this, "Введите сумму", Toast.LENGTH_SHORT).show();
                    return;
                }else {
                    Toast.makeText(Payment_Activity.this, "Оплата произведена", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}