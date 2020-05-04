# Pi2Cook- An smart Android Application with food ingredient recognition and dish recommendation.

![](https://img.shields.io/appveyor/build/gruntjs/grunt)
![](https://img.shields.io/badge/license-MIT-blue) 
![](https://img.shields.io/badge/Android-7.0%2B-blue)

This is the grauation project of my Bachlor degree of Enginnering in South China University of Technology. A image recoginition Android Application with a recipe recommend systems.

![image](https://github.com/Magicboomliu/Graduation_Project-SCUT-/blob/master/imags/ccc.png)

## Background and introducation  

The reason why I conducted this research is that during the special period like now when everyone stay at home, It was a very troublesome to decide what to cook at home everyday for everyone, and It is not very convenient to buy vegetables outside. So this application with food ingredient recognition and dishes recommend functions can allow user to decide what to cook with the ingredient have already have at home very quickly and convenient.

![image](https://github.com/Magicboomliu/Graduation_Project-SCUT-/blob/master/imags/hahahaha.png)

The picture below is the logic structure of the application, it can both used in the supermarket or at home. First , users take pictures and do ingredient recognition, in the mean time, user can make speech input for supplement and preference settings. Finally, the recommendation system will give recipe recommendation based on both the recognition result and the information that the user provided.

### Facing Problems and Dataset Preparation

First , About the food ingredient recognition part. The dataset I chose is MV80-Maket , a dataset conducted by Peking University. It has many images with many classes which is big enough to build a ingredient classifier model.
However, there are still some challenging problems in the dataset images 
![image](https://github.com/Magicboomliu/Graduation_Project-SCUT-/blob/master/imags/uploader01.png)
* Coverage problems
* package problems, 
* overexposed problems caused by the light 

## The Food Ingredient Model  
### The YoloV3-SRN hybrid Network  
