package com.mlib.io;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.view.View;

/** Minimal thin-line icon button (folder). Same stroke weight/colour as RefreshView. */
final class IconView extends View {
    static final int ICON = 0xFFBDBDBD;
    private final Paint p = new Paint(Paint.ANTI_ALIAS_FLAG);
    private final Path path = new Path();

    IconView(Context c, String description) {
        super(c);
        float d = c.getResources().getDisplayMetrics().density;
        p.setStyle(Paint.Style.STROKE);
        p.setStrokeWidth(1.8f * d);
        p.setStrokeJoin(Paint.Join.ROUND);
        p.setStrokeCap(Paint.Cap.ROUND);
        p.setColor(ICON);
        setClickable(true);
        setContentDescription(description);
        setBackground(ripple());
    }

    static RippleDrawable ripple() {
        return new RippleDrawable(ColorStateList.valueOf(0x33FFFFFF), null, new ShapeDrawable(new OvalShape()));
    }

    @Override
    protected void onDraw(Canvas cv) {
        float u = 24f * getResources().getDisplayMetrics().density / 24f; // 1 unit = 1dp on a 24dp grid
        float ox = (getWidth() - 24 * u) / 2f, oy = (getHeight() - 24 * u) / 2f;
        p.setPathEffect(new CornerPathEffect(2f * u));
        path.reset();
        path.moveTo(ox + 3 * u, oy + 6 * u);
        path.lineTo(ox + 9.5f * u, oy + 6 * u);
        path.lineTo(ox + 11.5f * u, oy + 8.5f * u);
        path.lineTo(ox + 21 * u, oy + 8.5f * u);
        path.lineTo(ox + 21 * u, oy + 19 * u);
        path.lineTo(ox + 3 * u, oy + 19 * u);
        path.close();
        cv.drawPath(path, p);
    }
}
