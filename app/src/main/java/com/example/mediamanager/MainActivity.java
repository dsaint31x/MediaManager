package com.example.mediamanager;

import android.content.Intent;
import android.database.Cursor;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.mediamanager.common.MediaData;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    public static String TYPE = "TYPE";
    public static final int TYPE_IMAGE = 0;
    public static final int TYPE_VIDEO = 1;
    public static final int TYPE_ALL = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button imgBtn = (Button)findViewById(R.id.imagebtn);
        imgBtn.setOnClickListener(this);

        Button videoBtn = (Button)findViewById(R.id.videobtn);
        videoBtn.setOnClickListener(this);

        Button allBtn = (Button)findViewById(R.id.allbtn);
        allBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        switch(v.getId())
        {
            case R.id.imagebtn:
                openImageViewer();
                break;
            case R.id.videobtn:
                openVideoPlayer();
                break;
            case R.id.allbtn:
                openAll();
                break;
            default:
                break;
        }
    }

    private void openImageViewer()
    {
        // 버튼을 클릭하면 이미지를 볼 수 있는 뷰어 액티비티를
        // 실행할 수 있도록 추가한다.
        Intent i = new Intent(this, ImageGridActivity.class);
        i.putExtra(TYPE, TYPE_IMAGE);
        startActivity(i);
    }

    private void openVideoPlayer()
    {
        // 단말의 비디오 파일들을 thumbnail를 이용하여
        //화면에 보여주는 액티비티를 호출 한다.
        Intent i = new Intent(this, ImageGridActivity.class);
        i.putExtra(TYPE, TYPE_VIDEO);
        startActivity(i);
    }

    private void openAll()
    {
        // 단말의 비디오 파일들을 thumbnail를 이용하여
        //화면에 보여주는 액티비티를 호출 한다.
        Intent i = new Intent(this, ImageGridActivity.class);
        i.putExtra(TYPE, TYPE_ALL);
        startActivity(i);
    }
}

