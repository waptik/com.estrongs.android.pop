.class Lcom/estrongs/android/ui/e/em;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/estrongs/android/view/a/b;


# instance fields
.field final synthetic a:Lcom/estrongs/android/ui/e/cp;


# direct methods
.method constructor <init>(Lcom/estrongs/android/ui/e/cp;)V
    .locals 0

    iput-object p1, p0, Lcom/estrongs/android/ui/e/em;->a:Lcom/estrongs/android/ui/e/cp;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/estrongs/android/ui/e/co;)Z
    .locals 2

    const/4 v0, 0x1

    iget-boolean v1, p1, Lcom/estrongs/android/ui/e/co;->e:Z

    if-eqz v1, :cond_1

    iget v1, p1, Lcom/estrongs/android/ui/e/co;->F:I

    if-ne v1, v0, :cond_1

    iget-boolean v1, p1, Lcom/estrongs/android/ui/e/co;->I:Z

    if-nez v1, :cond_0

    iget-boolean v1, p1, Lcom/estrongs/android/ui/e/co;->J:Z

    if-eqz v1, :cond_1

    :cond_0
    :goto_0
    return v0

    :cond_1
    iget-boolean v1, p1, Lcom/estrongs/android/ui/e/co;->m:Z

    if-nez v1, :cond_2

    iget-boolean v1, p1, Lcom/estrongs/android/ui/e/co;->A:Z

    if-eqz v1, :cond_3

    :cond_2
    iget v1, p1, Lcom/estrongs/android/ui/e/co;->F:I

    if-eq v1, v0, :cond_0

    :cond_3
    const/4 v0, 0x0

    goto :goto_0
.end method