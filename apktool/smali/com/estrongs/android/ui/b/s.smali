.class Lcom/estrongs/android/ui/b/s;
.super Ljava/lang/Object;

# interfaces
.implements Landroid/view/View$OnClickListener;


# instance fields
.field final synthetic a:Ljava/lang/String;

.field final synthetic b:Lcom/estrongs/android/ui/b/q;


# direct methods
.method constructor <init>(Lcom/estrongs/android/ui/b/q;Ljava/lang/String;)V
    .locals 0

    iput-object p1, p0, Lcom/estrongs/android/ui/b/s;->b:Lcom/estrongs/android/ui/b/q;

    iput-object p2, p0, Lcom/estrongs/android/ui/b/s;->a:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2

    iget-object v0, p0, Lcom/estrongs/android/ui/b/s;->b:Lcom/estrongs/android/ui/b/q;

    iget-object v1, p0, Lcom/estrongs/android/ui/b/s;->a:Ljava/lang/String;

    invoke-static {v0, v1}, Lcom/estrongs/android/ui/b/q;->a(Lcom/estrongs/android/ui/b/q;Ljava/lang/String;)V

    return-void
.end method
