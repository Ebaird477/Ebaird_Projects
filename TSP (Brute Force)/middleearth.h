#include <iostream>
#include <vector>
#include <string>
#include <map>

#ifndef MIDDLEEARTH_H
#define MIDDLEEARTH_H

using namespace std;

// see the comments in the lab11 write-up, or in middleearth.cpp

class MiddleEarth {
private:
    int num_city_names, xsize, ysize;
    vector<float> xpos, ypos;
    vector<string> cities;
    float *distances;
    map<string, int> indices;

public:

 /** @brief This is the constructor of "Middle Earth"
 *
 * This function creates the map using the size of the x and y axis,
 * number of cities and the seed given.
 * @return Constructed Middle Earth Model.
 * @param xsize This, in tandem with the ysize, helps construct the 2D array 
 * @param ysize This, in tandem with the xsize, helps construct the 2D array 
 * @param numcities determines the number of cities to help with random generation
 * @param seed Helps with the randomization.
 */
MiddleEarth (int xsize, int ysize, int numcities, int seed);


 /** @brief This is the de-constructor of "Middle Earth"
 *
 * This function creates the previously created Map.
 * @return nothing, it destroyed the Middle Earth Model.
 */
~MiddleEarth();


 /** @brief This is the function to print information on "Middle Earth".
 *
 * This function exports information of previously created Map.
 * @return information printed through COUT, conveying the Middle Earth Model.
 */
void print();


 /** @brief This is the function to export "Middle Earth" to excel.
 *
 * This function exports the previously created Map.
 * @return exported map, it conveyed the Middle Earth Model.
 */
void printTable();


 /** @brief This function serves to see the distance between two cities. 
 *
 * This function calculates the distance between these selected two cities
 * @return Float of the calculated distance.
 * @param city1 This is a city that has been selected to travel between
 * @param city2 This is a city that has been selected to travel between 
 */
float getDistance (string city1, string city2);


/** @brief This function offers an analytical look at the city availability based on length 
 *
 * This function finds available cities given a provided length.
 * @return A set of cities that are within the length
 * @param length this is an unsigned int used for measure. 
 */
vector<string> getItinerary(unsigned int length);
};

#endif
