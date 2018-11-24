// student name  : Woohyeon Baek
// student number: 2017-15782

#include "MyVector.h"
#include <iostream>

//constructor
MyVector::MyVector(const double numList[], int size) {
    VectorSize = size;
    V = new double[VectorSize];
    for(int i = 0; i < VectorSize; i++)
        V[i] = numList[i];
}

//constructor for nothing
MyVector::MyVector() { VectorSize = 0; V = 0; }

//copy constructor
MyVector::MyVector(const MyVector &vec) {
    VectorSize = vec.VectorSize;
    V = new double[VectorSize];
    for(int i = 0; i < VectorSize; i++)
        V[i] = vec.V[i];
}

//destructor
MyVector::~MyVector() { delete[] V; }

//assignment operator
MyVector& MyVector::operator=(const MyVector &vec) {
    if(this != &vec) {
        delete[] V;
        VectorSize = vec.VectorSize;
        V = new double[VectorSize];
        for(int i = 0; i < VectorSize; i++)
            V[i] = vec.V[i];
    }
    return *this;
}

//print function
void MyVector::print() const {
    std::cout << '(';
    if(VectorSize) {
        std::cout << V[0];
        for(int i = 1; i < VectorSize; i++)
            std::cout << ", " << V[i];
    }
    std::cout << ')';
}

/*************************************************************************
**************************************************************************
***When "MyVector" appears before "MyVector"  ****************************
*************************************************************************/

// vector + vector
MyVector MyVector::operator+(const MyVector &vec) {
    if(VectorSize != vec.VectorSize) {
        std::cout << "+ cannot be applied to ";
        print();
        std::cout << " and ";
        vec.print();
        std::cout << std::endl;
        return MyVector();
    }
    double U[VectorSize];
    for(int i = 0; i < VectorSize; i++)
        U[i] = V[i] + vec.V[i];
    return MyVector(U, VectorSize);
}

// vector * vector
double MyVector::operator*(const MyVector &vec) {
    if(VectorSize != vec.VectorSize) {
        std::cout << "* cannot be applied to ";
        print();
        std::cout << " and ";
        vec.print();
        std::cout << std::endl;
        return 0;
    }
    double U = 0;
    for(int i = 0; i < VectorSize; i++)
        U += V[i] * vec.V[i];
    return U;
}

// vector / vector
MyVector MyVector::operator/(const MyVector &vec) {
    std::cout << "/ cannot be applied to ";
    print();
    std::cout << " and ";
    vec.print();
    std::cout << std::endl;
    return MyVector();
}

// vector - vector
MyVector MyVector::operator-(const MyVector &vec) {
    if(VectorSize != vec.VectorSize) {
        std::cout << "- cannot be applied to ";
        print();
        std::cout << " and ";
        vec.print();
        std::cout << std::endl;
        return MyVector();
    }
    double U[VectorSize];
    for(int i = 0; i < VectorSize; i++)
        U[i] = V[i] - vec.V[i];
    return MyVector(U, VectorSize);
}

//You should add more operators described in the Assignment 5 pdf
//You may add more operator overloading to print error messages.

/*************************************************************************
**************************************************************************
***When "Scalar(double)" appears before "MyVector"  **********************
*************************************************************************/

// scalar + vector
MyVector operator+(double num, const MyVector &vec) {
    double U[vec.VectorSize];
    for(int i = 0; i < vec.VectorSize; i++)
        U[i] = num + vec.V[i];
    return MyVector(U, vec.VectorSize);
}

// scalar * vector
MyVector operator*(double num, const MyVector &vec) {
    double U[vec.VectorSize];
    for(int i = 0; i < vec.VectorSize; i++)
        U[i] = num * vec.V[i];
    return MyVector(U, vec.VectorSize);
}

// scalar / vector
MyVector operator/(double num, const MyVector &vec) {
    std::cout << "/ cannot be applied to " << num << " and ";
    vec.print();
    std::cout << std::endl;
    return MyVector();
}

// scalar - vector
MyVector operator-(double num, const MyVector &vec) {
  //As you know you should print error messages for invalid operation.
    std::cout << "- cannot be applied to " << num << " and ";
    vec.print();
    std::cout << std::endl;
    return MyVector();
}

/*************************************************************************
**************************************************************************
***When "MyVector" appears before "Scalar(double)"  **********************
*************************************************************************/

// vector + scalar
MyVector MyVector::operator+(double num) {
    double U[VectorSize];
    for(int i = 0; i < VectorSize; i++)
        U[i] = V[i] + num;
    return MyVector(U, VectorSize);
}

// vector * scalar
MyVector MyVector::operator*(double num) {
    double U[VectorSize];
    for(int i = 0; i < VectorSize; i++)
        U[i] = V[i] * num;
    return MyVector(U, VectorSize);
}

// vector / scalar
MyVector MyVector::operator/(double num) {
    if(num == 0) {
        std::cout << "/ cannot be applied to ";
        print();
        std::cout << " and " << num << std::endl;
        return MyVector();
    }
    double U[VectorSize];
    for(int i = 0; i < VectorSize; i++)
        U[i] = V[i] / num;
    return MyVector(U, VectorSize);
}

// vector - scalar
MyVector MyVector::operator-(double num) {
    double U[VectorSize];
    for(int i = 0; i < VectorSize; i++)
        U[i] = V[i] - num;
    return MyVector(U, VectorSize);
}
