package com.mayqlzu.android.pageindicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by mayq on 17-3-26.
 */
public class PageIndicator extends View {
    private Paint paint;
    private int index = 0;

    // TODO: you can design these as custom attributes, and this view will be more useful.
    private int COUNT = 3;
    private int RADIUS_PX = 30;
    private int GAP_PX = 30;
    private int COLOR_HIGHLIGHT = Color.RED;
    private int COLOR_NORMAL = Color.GREEN;


    public PageIndicator(Context context, AttributeSet attrs) {
        super(context, attrs);

        paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
    }

    /**
     * i dont' care what width/height you set in xml, just wrap content
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int w = (RADIUS_PX * 2 + GAP_PX) * COUNT - GAP_PX;
        int h = RADIUS_PX * 2;
        setMeasuredDimension(w, h);
    }

    /**
     * draw some dots
     *
     * @param canvas
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // (x,y)for the first dot
        int centerX = RADIUS_PX;
        int centerY = RADIUS_PX;
        int color = 0;
        for (int i = 0; i < COUNT; i++) {
            if (i == index) {
                color = COLOR_HIGHLIGHT;
            } else {
                color = COLOR_NORMAL;
            }
            paint.setColor(color);

            //public void drawCircle(float cx, float cy, float radius, @NonNull Paint paint) {
            canvas.drawCircle(centerX, centerY, RADIUS_PX, paint);

            // x for the next dot
            centerX += RADIUS_PX * 2 + GAP_PX;
        }
    }

    public void setCurrentIndex(int index) {
        this.index = index;

        // redraw
        invalidate();
    }

    public int getCurrentIndex() {
        return index;
    }

    public int getCount() {
        return COUNT;
    }
}
