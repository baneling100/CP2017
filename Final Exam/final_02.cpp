// student   name: Woohyeon Baek
// student number: 2017-15782

#include <stdio.h>
#include <string.h>

struct student {
    char name[300];
    char ignore[300];
    int grade;

    // for grade
    bool operator<(const student &X) { return grade < X.grade; };
    bool operator>(const student &X) { return grade > X.grade; };
    // for name
    bool operator<=(const student &X) { return strcmp(ignore,X.ignore) < 0; };
    bool operator>=(const student &X) { return strcmp(ignore,X.ignore) > 0; };
} A[300];

int N;

int main(void) {

    student temp;
    char temp1[30], temp2[30], a[30], b[30];

    scanf("%s %s %s %s %d", temp1, temp2, a, b, &N);

    for(int i = 0; i < N; i++) {
        scanf("%s %d", A[i].name, &A[i].grade);

        int len = strlen(A[i].name);
        A[i].name[len-1] = 0;
        len--;

        for(int j = 0; j < len; j++) {
            char ch = A[i].name[j];
            if('a' <= ch && ch <= 'z')
                ch += 'A' - 'a';
            A[i].ignore[j] = ch;
        }
    }

    if(a[0] == 'G') {
        if(b[1] == 'I') {
            for(int i = 0; i < N - 1; i++)
                for(int j = N - 1; j >= i + 1; j--)
                    if(A[j - 1] > A[j]) {
                        temp = A[j - 1];
                        A[j - 1] = A[j];
                        A[j] = temp;
                    }
        }
        else
            for(int i = 0; i < N - 1; i++)
                for(int j = N - 1; j >= i + 1; j--)
                    if(A[j - 1] < A[j]) {
                        temp = A[j - 1];
                        A[j - 1] = A[j];
                        A[j] = temp;
                    }
    }
    else {
        if(b[1] == 'I') {
            for(int i = 0; i < N - 1; i++)
                for(int j = N - 1; j >= i + 1; j--)
                    if(A[j - 1] >= A[j]) {
                        temp = A[j - 1];
                        A[j - 1] = A[j];
                        A[j] = temp;
                    }
        }
        else
            for(int i = 0; i < N - 1; i++)
                for(int j = N - 1; j >= i + 1; j--)
                    if(A[j - 1] <= A[j]) {
                        temp = A[j - 1];
                        A[j - 1] = A[j];
                        A[j] = temp;
                    }
    }

    for(int i = 0; i < N; i++)
        printf("%s, %d\n", A[i].name, A[i].grade);

    return 0;
}
