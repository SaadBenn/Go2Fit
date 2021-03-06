package comp3350.go2fit.Application;
/*
 * Copyright (C) 2016 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import comp3350.go2fit.PresentationLayer.ChallengesFragement;
import comp3350.go2fit.PresentationLayer.HomePageFragement;
import comp3350.go2fit.PresentationLayer.AchieveUI;
import comp3350.go2fit.PresentationLayer.TrackProgressUI;
import comp3350.go2fit.PresentationLayer.SetGoalsUI;

/**Fragment to return the clicked tab**/
public class PagerAdapter extends FragmentStatePagerAdapter
{
    int mNumOfTabs;

    public PagerAdapter(FragmentManager fm, int NumOfTabs)
    {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position)
    {
        switch (position)
        {
            case 0:
                return new HomePageFragement();
            case 1:
                return new ChallengesFragement();
            case 2:
                return new TrackProgressUI();
            case 3:
                return new SetGoalsUI();
            case 4:
                return new AchieveUI();
            default:
                return null;
        }
    }

    @Override
    public int getCount()
    {
        return mNumOfTabs;
    }
}