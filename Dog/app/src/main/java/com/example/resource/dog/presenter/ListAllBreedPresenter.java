package com.example.resource.dog.presenter;

import com.example.resource.dog.ui.activity.IListAllBreedActivity;
import com.example.resource.dog.ui.activity.shape.CurvedBottomNavigationView;

public class ListAllBreedPresenter implements IListAllBreedPresenter {
    IListAllBreedActivity view;

    public ListAllBreedPresenter(IListAllBreedActivity view) {
        this.view = view;
    }

    @Override
    public void curvedRight(CurvedBottomNavigationView navigation) {
        // get width and height of navigation bar
        // Navigation bar bounds (width & height)
        //mNavigationBarHeight = getHeight();
        //mNavigationBarWidth = getWidth();
        // the coordinates (x,y) of the start point before curve
        navigation.mFirstCurveStartPoint.set((navigation.mNavigationBarWidth * 10/12) - (navigation.CURVE_CIRCLE_RADIUS * 2) - (navigation.CURVE_CIRCLE_RADIUS / 3), 0);
        // the coordinates (x,y) of the end point after curve
        navigation.mFirstCurveEndPoint.set(navigation.mNavigationBarWidth  * 10/12, navigation.CURVE_CIRCLE_RADIUS + (navigation.CURVE_CIRCLE_RADIUS / 4));
        // same thing for the second curve
        navigation.mSecondCurveStartPoint = navigation.mFirstCurveEndPoint;
        navigation.mSecondCurveEndPoint.set((navigation.mNavigationBarWidth  * 10/12) + (navigation.CURVE_CIRCLE_RADIUS * 2) + (navigation.CURVE_CIRCLE_RADIUS / 3), 0);

        // the coordinates (x,y)  of the 1st control point on a cubic curve
        navigation.mFirstCurveControlPoint1.set(navigation.mFirstCurveStartPoint.x + navigation.CURVE_CIRCLE_RADIUS + (navigation.CURVE_CIRCLE_RADIUS / 4), navigation.mFirstCurveStartPoint.y);
        // the coordinates (x,y)  of the 2nd control point on a cubic curve
        navigation.mFirstCurveControlPoint2.set(navigation.mFirstCurveEndPoint.x - (navigation.CURVE_CIRCLE_RADIUS * 2) + navigation.CURVE_CIRCLE_RADIUS, navigation.mFirstCurveEndPoint.y);

        navigation.mSecondCurveControlPoint1.set(navigation.mSecondCurveStartPoint.x + (navigation.CURVE_CIRCLE_RADIUS * 2) - navigation.CURVE_CIRCLE_RADIUS, navigation.mSecondCurveStartPoint.y);
        navigation.mSecondCurveControlPoint2.set(navigation.mSecondCurveEndPoint.x - (navigation.CURVE_CIRCLE_RADIUS + (navigation.CURVE_CIRCLE_RADIUS / 4)), navigation.mSecondCurveEndPoint.y);
        view.getPositionCurved(navigation);
    }

    @Override
    public void curvedLeft(CurvedBottomNavigationView navigation) {
        int i = 6;
        navigation.mFirstCurveStartPoint.set((navigation.mNavigationBarWidth / i) - (navigation.CURVE_CIRCLE_RADIUS * 2) - (navigation.CURVE_CIRCLE_RADIUS / 3), 0);
        // the coordinates (x,y) of the end point after curve
        navigation.mFirstCurveEndPoint.set(navigation.mNavigationBarWidth / i, navigation.CURVE_CIRCLE_RADIUS + (navigation.CURVE_CIRCLE_RADIUS / 4));
        // same thing for the second curve
        navigation.mSecondCurveStartPoint = navigation.mFirstCurveEndPoint;
        navigation.mSecondCurveEndPoint.set((navigation.mNavigationBarWidth / i) + (navigation.CURVE_CIRCLE_RADIUS * 2) + (navigation.CURVE_CIRCLE_RADIUS / 3), 0);

        // the coordinates (x,y)  of the 1st control point on a cubic curve
        navigation.mFirstCurveControlPoint1.set(navigation.mFirstCurveStartPoint.x + navigation.CURVE_CIRCLE_RADIUS + (navigation.CURVE_CIRCLE_RADIUS / 4), navigation.mFirstCurveStartPoint.y);
        // the coordinates (x,y)  of the 2nd control point on a cubic curve
        navigation.mFirstCurveControlPoint2.set(navigation.mFirstCurveEndPoint.x - (navigation.CURVE_CIRCLE_RADIUS * 2) + navigation.CURVE_CIRCLE_RADIUS, navigation.mFirstCurveEndPoint.y);

        navigation.mSecondCurveControlPoint1.set(navigation.mSecondCurveStartPoint.x + (navigation.CURVE_CIRCLE_RADIUS * 2) - navigation.CURVE_CIRCLE_RADIUS, navigation.mSecondCurveStartPoint.y);
        navigation.mSecondCurveControlPoint2.set(navigation.mSecondCurveEndPoint.x - (navigation.CURVE_CIRCLE_RADIUS + (navigation.CURVE_CIRCLE_RADIUS / 4)), navigation.mSecondCurveEndPoint.y);
        view.getPositionCurved(navigation);
    }

    @Override
    public void curvedCenter(CurvedBottomNavigationView navigation) {
        int i = 2;
        navigation.mFirstCurveStartPoint.set((navigation.mNavigationBarWidth / i) - (navigation.CURVE_CIRCLE_RADIUS * 2) - (navigation.CURVE_CIRCLE_RADIUS / 3), 0);
        // the coordinates (x,y) of the end point after curve
        navigation.mFirstCurveEndPoint.set(navigation.mNavigationBarWidth / i, navigation.CURVE_CIRCLE_RADIUS + (navigation.CURVE_CIRCLE_RADIUS / 4));
        // same thing for the second curve
        navigation.mSecondCurveStartPoint = navigation.mFirstCurveEndPoint;
        navigation.mSecondCurveEndPoint.set((navigation.mNavigationBarWidth / i) + (navigation.CURVE_CIRCLE_RADIUS * 2) + (navigation.CURVE_CIRCLE_RADIUS / 3), 0);

        // the coordinates (x,y)  of the 1st control point on a cubic curve
        navigation.mFirstCurveControlPoint1.set(navigation.mFirstCurveStartPoint.x + navigation.CURVE_CIRCLE_RADIUS + (navigation.CURVE_CIRCLE_RADIUS / 4), navigation.mFirstCurveStartPoint.y);
        // the coordinates (x,y)  of the 2nd control point on a cubic curve
        navigation.mFirstCurveControlPoint2.set(navigation.mFirstCurveEndPoint.x - (navigation.CURVE_CIRCLE_RADIUS * 2) + navigation.CURVE_CIRCLE_RADIUS, navigation.mFirstCurveEndPoint.y);

        navigation.mSecondCurveControlPoint1.set(navigation.mSecondCurveStartPoint.x + (navigation.CURVE_CIRCLE_RADIUS * 2) - navigation.CURVE_CIRCLE_RADIUS, navigation.mSecondCurveStartPoint.y);
        navigation.mSecondCurveControlPoint2.set(navigation.mSecondCurveEndPoint.x - (navigation.CURVE_CIRCLE_RADIUS + (navigation.CURVE_CIRCLE_RADIUS / 4)), navigation.mSecondCurveEndPoint.y);
        view.getPositionCurved(navigation);
    }

//    @Override
//    public boolean identificaItemMenuClicado(@NonNull MenuItem menuItem) {
//
//        return false;
//    }


}
