package cooks;

import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;

import com.example.pic2cook_develop.Detailed_ingredients;
import com.example.pic2cook_develop.MainActivity;
import com.example.pic2cook_develop.R;
import com.example.pic2cook_develop.Virus_protection;

import java.util.Calendar;
import java.util.Date;

import static android.content.Context.ALARM_SERVICE;


public class recommend_Fragment extends Fragment {
    private TextView toseemore;
    private Button coravirus;
    private ImageView pizza_checked;
    private ImageView robuster_checked;
    private ImageView sushi_checked;
    private ImageView dango_checked;
    private int ispizza = 0;
    private int isdango = 0;
    private int issushi = 0;
    private int isrobuster = 0;
    private Switch myswitch;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recommend_fragment, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        toseemore = view.findViewById(R.id.to_see_more);
        coravirus = view.findViewById(R.id.cornavirus);
        pizza_checked = view.findViewById(R.id.piazzschecked);

        robuster_checked = view.findViewById(R.id.robuster_checked);
        sushi_checked = view.findViewById(R.id.shushi_checked);
        dango_checked = view.findViewById(R.id.dango_checked);
        myswitch = view.findViewById(R.id.myswitch);

        pizza_checked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (ispizza == 0) {
                    pizza_checked.setImageResource(R.drawable.heart_clicked);
                    ispizza = 1;
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(getActivity());
                    View view2 = LayoutInflater.from(getActivity()).inflate(R.layout.alert_dailog_saved, null);
                    builder1.setView(view2).show();

                } else {
                    pizza_checked.setImageResource(R.drawable.heart_uncliked);
                    ispizza = 0;
                }
            }
        });

        robuster_checked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isrobuster == 0) {
                    robuster_checked.setImageResource(R.drawable.heart_clicked);
                    isrobuster = 1;
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(getActivity());
                    View view2 = LayoutInflater.from(getActivity()).inflate(R.layout.alert_dailog_saved, null);
                    builder1.setView(view2).show();
                } else {
                    robuster_checked.setImageResource(R.drawable.heart_uncliked);

                    isrobuster = 0;
                }
            }
        });
        sushi_checked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (issushi == 0) {
                    sushi_checked.setImageResource(R.drawable.heart_clicked);
                    isrobuster = 1;
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(getActivity());
                    View view2 = LayoutInflater.from(getActivity()).inflate(R.layout.alert_dailog_saved, null);
                    builder1.setView(view2).show();
                } else {
                    sushi_checked.setImageResource(R.drawable.heart_uncliked);
                    isrobuster = 0;
                }

            }
        });

        dango_checked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isdango == 0) {
                    dango_checked.setImageResource(R.drawable.heart_clicked);
                    isdango = 1;
                } else {
                    dango_checked.setImageResource(R.drawable.heart_uncliked);
                    isdango = 0;
                }
            }
        });

        toseemore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it1 = new Intent(getContext(), Detailed_ingredients.class);
                startActivity(it1);
            }
        });
        coravirus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it2 = new Intent(getContext(), Virus_protection.class);
                startActivity(it2);
            }
        });

        myswitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(getActivity());
                    View view2 = LayoutInflater.from(getActivity()).inflate(R.layout.alertdialogue2, null);
                    TextView cancel_clock = view2.findViewById(R.id.cancel_clock);
                    TextView confrim_clock = view2.findViewById(R.id.confrim_clock);
                    builder1.setView(view2);
                    final AlertDialog dia = builder1.show();
                    cancel_clock.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dia.dismiss();


                        }
                    });
                    confrim_clock.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dia.dismiss();
                            showT();

                        }
                    });
                } else {

                    myNotification("Pic2Cook Tips", "您的早餐闹铃已经关闭!");
                }
            }
        });

    }

    public void myNotification(String strTitle, String strContent) {
        NotificationManager manager = (NotificationManager) getActivity().getSystemService(Context.NOTIFICATION_SERVICE);
        //高版本需要渠道
        if (Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            //只在Android O之上需要渠道，这里的第一个参数要和下面的channelId一样
            NotificationChannel notificationChannel = new NotificationChannel("1", "name", NotificationManager.IMPORTANCE_HIGH);
            //如果这里用IMPORTANCE_NOENE就需要在系统的设置里面开启渠道，通知才能正常弹出
            manager.createNotificationChannel(notificationChannel);
        }
//这里的第二个参数要和上面的第一个参数一样
        Notification notification = new NotificationCompat.Builder(getContext(), "1")
                .setContentTitle(strTitle)
                .setContentText(strContent)
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.mipmap.pic2cook_icon)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.pic2cook_with_slogan))
                .build();
        manager.notify(1, notification);

    }
    public void showT(){

        TimePickerDialog timePickerDialog = new TimePickerDialog(getContext(), new TimePickerDialog.OnTimeSetListener() {

            @Override
            public void onTimeSet(TimePicker timePicker, int hours, int minutes) {
                myNotification("Pic2Cook Tips", "您的早餐闹铃已经设置成功!");
            }
        }, 0, 0, true);
        timePickerDialog.show();

    }

}
