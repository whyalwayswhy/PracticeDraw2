package com.hencoder.hencoderpracticedraw2.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Practice03SweepGradientView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public Practice03SweepGradientView(Context context) {
        super(context);
    }

    public Practice03SweepGradientView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice03SweepGradientView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        // 用 Paint.setShader(shader) 设置一个 SweepGradient
        // SweepGradient 的参数：圆心坐标：(300, 300)；颜色：#E91E63 到 #2196F3
        List<Integer> colors = Arrays.asList(
                Color.parseColor("#FF0000"), // 红色
                Color.parseColor("#FFFF00"), // 黄色
                Color.parseColor("#00FF00"), // 绿色
                Color.parseColor("#00FFFF"), // 青色
                Color.parseColor("#0000FF"), // 蓝色
                Color.parseColor("#FF00FF"), // 紫色
                Color.parseColor("#FF0000") // 红色
        );
        List<Float> positions = Arrays.asList(
                0.0f,   // 0度
                0.166f, // 60度
                0.333f, // 120度
                0.5f,   // 180度
                0.666f, // 240度
                0.833f, // 300度
                1.0f    // 360度
        );
        float[] positionsArray = new float[positions.size()];
        AtomicInteger index = new AtomicInteger();
        positions.forEach(item -> {
            positionsArray[index.getAndIncrement()] = item;
        });
//        Shader shader = new SweepGradient(300, 300, Color.parseColor("#E91E63"), Color.parseColor("#2196F3"));
        Shader shader = new SweepGradient(300, 300, colors.stream().mapToInt(Integer::intValue).toArray(), positionsArray);
        paint.setShader(shader);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawCircle(300, 300, 200, paint);
    }
}
