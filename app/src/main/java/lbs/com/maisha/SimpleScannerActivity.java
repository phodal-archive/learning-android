package lbs.com.maisha;

import android.os.Bundle;
import android.widget.Toast;

import com.jeremyfeinstein.slidingmenu.lib.app.SlidingActivity;

import me.dm7.barcodescanner.zbar.Result;
import me.dm7.barcodescanner.zbar.ZBarScannerView;

public class SimpleScannerActivity extends SlidingActivity implements ZBarScannerView.ResultHandler {
    private ZBarScannerView mScannerView;

    @Override
    public void onCreate(Bundle state) {
        super.onCreate(state);
        setTitle(R.string.title);
        setContentView(R.layout.frame_content);
        setBehindContentView(R.layout.frame_menu);

        mScannerView = new ZBarScannerView(this);
        setContentView(mScannerView);
    }

    @Override
    public void onResume() {
        super.onResume();
        mScannerView.setResultHandler(this);
        mScannerView.startCamera();
    }

    @Override
    public void onPause() {
        super.onPause();
        mScannerView.stopCamera();
    }

    @Override
    public void handleResult(Result rawResult) {
        Toast.makeText(this, "Contents = " + rawResult.getContents() +
                ", Format = " + rawResult.getBarcodeFormat().toString(), Toast.LENGTH_SHORT).show();
        mScannerView.startCamera();
    }
}
