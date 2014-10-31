//============================================================================
// Name        : InterviewC++.cpp
// Author      : 
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;

#include<stdio.h>
#include<iostream>

using namespace std;

struct ListNode {
      int val;
      ListNode *next;
      ListNode(int x) : val(x), next(NULL) {}
  };

ListNode *mergeTwoLists(ListNode *l1, ListNode *l2)
{
       if(l1==NULL)
            return l2;
        else if (l2==NULL)
            return l1;
        else
        {
            ListNode *final;
            final=NULL;
            ListNode *traversal1,*traversal2;
            traversal1=l1;
            traversal2=l2;
            while(traversal1!=NULL || traversal2!=NULL)
            {
                if(traversal1->val > traversal2->val)
                {
                    if(final==NULL)
                        final=traversal2;
                    else
                        final->next=traversal2;
                    traversal2=traversal2->next;
                }
                else
                {
                    if(final==NULL)
                        final=traversal1;
                    else
                        final->next=traversal1;
                    traversal1=traversal1->next;
                }
            }
            if(traversal1==NULL)
                final->next=traversal2;
            else
                final->next=traversal1;
            final->next=NULL;
            return final;
        }
    }

int main(){
	
	ListNode *l1,*l2;
	ListNode *final;
	l1->val=10;
	l2->val=5;

    cout<<"HI";
	final=mergeTwoLists(l1,l2);
        while(final!=NULL)
	{
        cout<<"HI";
		cout<<" "<<final->val<<" ";

		final=final->next;
	}
	return 0;
}

