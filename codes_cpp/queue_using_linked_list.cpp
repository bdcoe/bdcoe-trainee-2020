#include <iostream>
using namespace std;
class node{
    public:
    int d;
    node* next;
    node(int data){
        d=data;
        next=NULL;
    }
};
void insert_at_tail(node *&head,int data){
    if(head==NULL){
        head=new node(data);
        return;
    }
    node *t=head;
    while(t->next!=NULL){
        t=t->next;
    }
    t->next=new node(data);;
}
void delete_at_head(node *&head){
    node *t=head;
    head=head->next;
    delete t;
    t=NULL;
}
class queue{
    public:
    node* head=NULL;
    void push(int data){
        insert_at_tail(head,data);
    }
    void pop(){
        delete_at_head(head);
    }
    int front(){
        return head->d;
    }
    bool isEmpty(){
        return head==NULL;
    }
    void print(){
        node *t=head;
        while(t!=NULL){
            cout<<t->d<<"->";
            t=t->next;
        }
    }
};
int main() {
    queue q;
    int n;
    cin>>n;
    for(int i=0;i<n;i++){
        int data;
        cin>>data;
        q.push(data);
    }
    q.pop();
    q.pop();
    q.print();
    cout<<q.isEmpty();
    return 0;
}